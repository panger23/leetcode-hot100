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
public class Question_26 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            // 指向空节点，说明无环。
            if(fast == null || fast.next == null) return null;
            // fast 和 slow 异速前进
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;// fast 和 slow 相遇
        }
        ListNode ptr = head;
        // ptr 和 slow 同速前进，直至相遇在入口
        while(ptr != slow){
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;// 返回入口节点
    }
}
