package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Question_44 {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历得到绝对排序的链表
        InOrder(root);
        return res.get(k-1);
    }
    // 和上一题（第98题）一摸一样的做法，中序遍历，复杂度一般
    public void InOrder(TreeNode root){
        if(root == null) return ;
        InOrder(root.left);
        res.add(root.val);
        InOrder(root.right);
        return;
    }
}