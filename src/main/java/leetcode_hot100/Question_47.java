package leetcode_hot100;

import java.util.HashMap;

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
class Question_47 {
    int[] preorder; // 用于构建全局变量preorder
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }
        // 根节点的索引，左边界索引，右边界索引
        // 0代表preorder第0个是跟节点
        // 0代表inOrder的左边界为0
        // inorder.length代表右边界
        return recur(0,0,inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;  // 递归终止
        TreeNode node = new TreeNode(preorder[root]); // 建立根节点
        int i = dic.get(preorder[root]); // 划分根节点、左子树、右子树
        // 根节点变为preorder第root+1个
        node.left = recur(root+1,left,i-1); // 开启左子树递归
        node.right = recur(root+i-left+1,i+1,right);  // 开启右子树递归
        return node; // 回溯返回根节点
    }
}