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
class Question_40 {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode root){

        if(root == null) return 0;
        int lLeft = dfs(root.left) ; // 左子树最大链长+1
        int rRight = dfs(root.right) ; // 右子树最大链长+1
        res = Math.max(res,lLeft + rRight); // 两条链拼成路径
        return Math.max(lLeft , rRight) + 1 ; // 当前子树最大链长

    }

}