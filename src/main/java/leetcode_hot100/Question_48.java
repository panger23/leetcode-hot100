package leetcode_hot100;

import java.util.HashMap;
import java.util.Map;

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
class Question_48 {
    private Map<Long,Integer> preSumCount = new HashMap<>();// 记录当前路径上出现的前缀和以及数量
    public int pathSum(TreeNode root, int targetSum) {
        preSumCount.put(0L,1); // 有一个默认的前缀和0
        return dfs(root,targetSum,0);// 从根节点开始搜索 0代表preSum
    }

    /**
     * 深度优先搜索，返回到达当前节点及其子节点可以得到满足条件的路径
     * @param node: 当前节点
     * @param targetSum: 目标和
     * @param preSum: 根节点到当前节点的路径
     * @return: 以当前节点为最后一个节点的，节点和等于目标和的路径数
     */
    private int dfs(TreeNode node,int targetSum,long preSum){
        if(node == null) return 0;// 空节点，满足条件路径数为0
        preSum = preSum + node.val;// 更新节点和
        int pathCnt = preSumCount.getOrDefault(preSum - targetSum,0);// 从哈希表中获取能和preSum配对的前缀和个数
        preSumCount.put(preSum, preSumCount.getOrDefault(preSum,0) + 1); // 将当前前缀和加入哈希表
        pathCnt = pathCnt + dfs(node.left,targetSum,preSum) + dfs(node.right,targetSum,preSum);// 递归处理左右子树
        preSumCount.put(preSum,preSumCount.get(preSum) - 1);  // 这个节点所在的路径都处理完了，这个前缀和也就没用了
        return pathCnt; // 返回总路径数
    }
}