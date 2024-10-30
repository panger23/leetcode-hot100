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
class Question_41 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List 是一个抽象类（或者接口），不能直接用 new 来实例化。
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 将跟节点放入队列,然后不断遍历队列
        queue.add(root);
        while(queue.size() > 0){
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
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
            // 将临时的temp放到res
            res.add(temp);
        }
        return res;
    }
}
