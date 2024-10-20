package leetcode_hot100;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Question_27 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 初始化： 伪头节点 dum ，节点 cur 指向 dum 。
        // 初始化一个辅助节点 dum 作为合并链表的伪头节点，将各节点添加至 dum 之后
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 如果一个链表遍历玩了，就将剩下的并入这个链表的后面
        cur.next = (list1 != null) ? list1 : list2;
        return dum.next;
    }
}
