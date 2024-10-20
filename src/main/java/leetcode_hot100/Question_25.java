package leetcode_hot100;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Question_25 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            // 必须有fast.next==null，因为否则fast = fast.next.next;报错
            if(fast == null || fast.next==null)  return false;
            slow = slow.next;
            fast = fast.next.next;
            // 如果slow和false相遇
            if(slow == fast)    return true;
        }
    }
}