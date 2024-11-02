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
class Question_42 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length-1); // nums,0,4
    }
    public TreeNode dfs(int[] nums,int l,int r ){
        if(l > r) return null;
        // 以升序数组的中间元素作为根节点 root。
        int mid = (l + r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树
        root.left = dfs(nums,l,mid-1);
        root.right = dfs(nums,mid+1,r);
        return root;
    }
}
