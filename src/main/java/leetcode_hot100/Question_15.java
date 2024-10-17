package leetcode_hot100;

import java.util.Arrays;

public class Question_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums,k);
    }
    public static  void rotate(int[] nums, int k) {

            k %=nums.length;
            int[] temp = new int[k];
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
            System.out.println(Arrays.toString(nums));

    }
    public static void reverse(int[] nums,int left,int right){
        while(left < right){
            int t = nums[left];
            nums[left++] = nums[right];
            nums[right--] = t;
        }
    }
}
