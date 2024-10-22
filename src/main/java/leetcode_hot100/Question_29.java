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
class Question_29 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        //删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
        pre.next = head;
        ListNode start = pre, end = pre;
        // 让前面的指针先移动 n 步
        while(n != 0){
            start = start.next;
            n--;
        }
        while(start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
}
