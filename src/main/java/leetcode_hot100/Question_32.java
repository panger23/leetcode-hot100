package leetcode_hot100;

import java.util.HashMap;
import java.util.Map;


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Question_32 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head; // 记录当前指向的节点
        Map<Node,Node> map = new HashMap<>(); // 集合映射原链表和新链表
        while(cur != null){
            Node temp = new Node(cur.val);
            map.put(cur,temp);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
