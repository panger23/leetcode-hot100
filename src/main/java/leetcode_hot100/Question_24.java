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
class Question_24 {
    public boolean isPalindrome(ListNode head) {
        // 使用快慢指针遍历到中间和末尾节点
        ListNode l = head;
        ListNode q = head;
        while(q != null && q.next != null){
            l = l.next;
            q = q.next.next;
        }
        // 翻转后半段列表
        ListNode cur = null;
        ListNode pre = l;
        while(pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        // cur指向最后一个节点，也是链表的起点
        while(cur != null && head != null){
            if(cur.val != head.val) return false;
            cur = cur.next;
            head = head.next;
        }
        return true;

    }
}
