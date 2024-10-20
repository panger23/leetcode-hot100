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
class Question_23 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode cur = null;

//         好理解的双指针

// 定义两个指针： pre 和 cur ；pre 在前 cur 在后。
// 每次让 pre 的 next 指向 cur ，实现一次局部反转
// 局部反转完成之后，pre 和 cur 同时往前移动一个位置
// 循环上述过程，直至 pre 到达链表尾部

        while(pre != null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
}
