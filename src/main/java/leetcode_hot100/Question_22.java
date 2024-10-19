package leetcode_hot100;

public class Question_22 {
    public static void main(String[] args) {
        // Construct List A: [4,1,8,4,5]
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        a1.next = a2;
        a2.next = c1;
        c1.next = c2;
        c2.next = c3;

        // Construct List B: [5,6,1,8,4,5]
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        b1.next = b2;
        b2.next = b3;
        b3.next = c1; // The intersection starts at node c1

        // Set intersectVal, skipA, and skipB
        int intersectVal = 8;
        int skipA = 2;
        int skipB = 3;

        ListNode intersection = getIntersectionNode(a1, b1);

        if (intersection != null && intersection.val == intersectVal) {
            System.out.println(intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA,pb = headB;
        while (pa != pb){
           pa = (pa == null) ? headB : pa.next;
           pb = (pb == null) ? headA : pb.next;

           // java的三元运算符
           // int a = 10;
            //int b = 20;
            //int max = (a > b) ? a : b;  // 如果 a 大于 b，返回 a；否则返回 b
            //System.out.println(max);  // 输出 20

        }
        return pa;
    }
}
// 这个类定义了一个链表节点，它存储一个整数值val，并且通过next指向下一个节点。
// ListNode(int x): 这是类的构造函数，用于创建一个新的ListNode对象。当创建一个节点时，传入的值x会赋值给val，表示节点的值。
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
       val = x;
       next = null;
    }
 }