package leetcode_hot100;

import java.util.*;
//背包
//dfs暴力
public class test {
    public static void main(String[] args){
        int N,V;
        Scanner scanner = new Scanner(System.in);
        N = 4;//物品数
        V = 5;//背包容积
        int[] v = new int[]{0,2,1,3,2};//一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] w = new int[]{0,3,2,4,2};//一个长度为N的数组，第i个元素表示第i个物品的价值；
//        //给每个物品赋体积和价值
//        for (int i = 1; i <= N; i++) {
//            v[i] = scanner.nextInt();
//            w[i] = scanner.nextInt();
//        }
        /**
         * （01背包）朴素解法
         */
/**
 * （完全背包）优化解法
 */
        int[][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-v[i]]+w[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][V]);

        /**
         * （01背包）优化解法
         */
        int []DP = new int[V+1];
        DP[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                DP[j] = Math.max(DP[j], DP[j-v[i]]+w[i]);
                //dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]]+w[i]);
                //逆序：dp[j-v[i]]还没有更新，因此更新dp[j]使用的是dp[i-1][j-v[i]]
                //正序：前一个i就已经更新了，因为这个数组是滚动数组。
            }
        }
        System.out.println("优化后的DP算法："+DP[V]);

    }
}
