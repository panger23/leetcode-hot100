package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Question_36 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }
    void dfs(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        // 根左右
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }
}