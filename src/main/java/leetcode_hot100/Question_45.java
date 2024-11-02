package leetcode_hot100;

import java.util.ArrayList;
import java.util.LinkedList;
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
// 层序遍历，一层返回一个 和102题思想一样的
class Question_45 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 将跟节点放入队列,然后不断遍历队列
        queue.add(root);
        while(queue.size() > 0){
            //获取当前队列的长度，这个长度相当于当前这一层的节点个数
            int size = queue.size();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            List<Integer> temp = new ArrayList<>();
            //拿出来的同时，如果节点的左/右子树不为空，也放入队列中
            for(int i = 0 ; i < size ; i++){
                TreeNode t = queue.remove();
                temp.add(t.val);
                if(t.left != null){
                    queue.add(t.left);
                }
                if(t.right != null){
                    queue.add(t.right);
                }
            }
            // 将temp（代表每一层的节点）的最右边的节点放到列表中
            res.add(temp.get(temp.size() - 1));
        }
        return res;
    }
}