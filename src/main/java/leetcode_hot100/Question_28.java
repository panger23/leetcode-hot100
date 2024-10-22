package leetcode_hot100;


//   class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

public class Question_28 {
    public static void main(String[] args) {
        // 构建链表 l1: [9,9,9,9,9,9,9]
        ListNode l1_1 = new ListNode(9);
        ListNode l1_2 = new ListNode(9);
        ListNode l1_3 = new ListNode(9);
        ListNode l1_4 = new ListNode(9);
        ListNode l1_5 = new ListNode(9);
        ListNode l1_6 = new ListNode(9);
        ListNode l1_7 = new ListNode(9);

        // 链接 l1 的节点
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;
        l1_5.next = l1_6;
        l1_6.next = l1_7;

        // 构建链表 l2: [9,9,9,9]
        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        ListNode l2_3 = new ListNode(9);
        ListNode l2_4 = new ListNode(9);

        // 链接 l2 的节点
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;

        ListNode result = addTwoNumbers(l1_1,l2_1);
        printList(result);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // int l1_length= 0;
        // int l2_length = 0;
        // // 计算l1的长度
        // while(l1 != null){
        //     l1_length++ ;
        // }
        // // 计算l2 的长度
        //   while(l2 != null){
        //     l2_length++ ;
        // }
        ListNode cur = l2;
        ListNode pre = l2;
        int v = 0;
        while(cur != null && l1 != null){
            if(l1.val + cur.val + v >=10) {
                cur.val = (l1.val + cur.val + v) % 10;
                v = 1;
            }else {
                cur.val = l1.val + cur.val + v;
                v = 0;
            };
            pre = cur;
            cur = cur.next;
            l1 = l1.next;

        }

        // 如果l2先遍历完
        if(l1 != null){
            if(l1.val  + v >= 10) {
                l1.val = (l1.val  + v) % 10;
                v = 1;
            }else {
                l1.val = l1.val + v;
                v = 0;
            };
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
        }
        // 如果还有剩余进位，需要在最后创建一个新节点

        return l2;
    }
    // 打印链表
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
