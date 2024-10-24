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
class Question_30 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        // 链表题一般都是先这样设置
        ListNode pre = new ListNode(0);
        pre.next = head;

        // temp一直指向要交换的两个数的前一个，初始为pre，后面就是start
        // 然后两个数交换
        ListNode temp = pre;
        while(temp.next != null && temp.next.next !=null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;

    }
}
