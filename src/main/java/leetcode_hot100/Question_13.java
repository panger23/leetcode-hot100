package leetcode_hot100;



public class Question_13 {
    public static  void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums)); // 方法1
        System.out.println(maxSubArray2(nums)); // 优化

    }

    public static int maxSubArray(int[] nums) {
        //动态规划
        // 如果nums[i]前面的树大于0，就要，否则不要从nums[i]开始算
        int[] dp = new int[nums.length];
        int sum = 0;

        dp[0] = nums[0];
        sum = dp[0];
        for(int i = 1; i < nums.length;i++){
            if(dp[i-1] > 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            sum = Math.max(sum,dp[i]);
        }
        return sum;
    }
    public static int maxSubArray2(int[] nums) {
        // 动态规划的优化
        // 因为dp[i]只与dp[i-1]有关
        // 所以令dp[i] = cur,dp[i-1] = pre
        int pre=nums[0],cur = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(pre > 0) cur = pre + nums[i];
            else cur = nums[i];
            sum = Math.max(sum,cur);
            pre = cur;
        }
        return sum;
    }

}
