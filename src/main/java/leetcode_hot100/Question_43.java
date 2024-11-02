package leetcode_hot100;

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
class Question_43 {
    private TreeNode pre = null; // 类成员变量

    public boolean isValidBST(TreeNode root) {
        return help(root);
    }

    public boolean help(TreeNode root) {
        if (root == null) return true;

        // 左子树
        if (!help(root.left)) return false;

        // 当前节点与前一个节点比较
        if (pre != null && pre.val >= root.val) return false;
        pre = root; // 更新 pre

        // 右子树
        return help(root.right);
    }
}