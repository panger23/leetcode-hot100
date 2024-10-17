package leetcode_hot100;

import java.util.Arrays;

public class Question_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        // 使用的一个技巧
        // 原数组：       [1       2       3       4]
        // 左部分的乘积：   1       1      1*2    1*2*3
        // 右部分的乘积： 2*3*4    3*4      4      1
        // 结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
        //  计算左半部分的乘积，计算右半部分的乘积s
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int l = 1;
        int r = 1;
        for (int i = 0, j = nums.length-1; i < nums.length; i++,j--) {
            left[i] = l;
            l = l * nums[i];
            right[j] = r;
            r = r * nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
