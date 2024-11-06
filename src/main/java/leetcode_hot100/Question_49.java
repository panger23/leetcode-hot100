package leetcode_hot100;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Question_49 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root; // p和q就是root，返回root
        TreeNode left = lowestCommonAncestor(root.left,p,q); // 遍历左子树
        TreeNode right = lowestCommonAncestor(root.right,p,q); // 遍历右子树
        if(left == null) return right; // 左子树为空，说明在右边，返回右子树
        if(right == null) return left; // 右子树为空，说明在左边，返回左子树
        return root; // 左右子树都存在，返回根节点
    }
}