package leetcode_hot100;

import java.util.*;

public class Question_06 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }
    public static List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums);// -4,-1,-1,0,1,2
        List<List<Integer>> lists = new ArrayList<>();


        for (int k = 0; k < nums.length-2; k++) {
            if (nums[k] > 0){
                break;
            }
            if (k>0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k+1;
            int j = nums.length-1;
            while (i<j){
                int sum = nums[k]+nums[i]+nums[j];
                if (sum < 0){
                    while (i<j && nums[i] == nums[++i]);
                    continue;
                }
                if (sum > 0){
                    while (i<j && nums[j] == nums[--j] );
                    continue;
                }
                if (sum == 0){
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[i] == nums[++i]);
                    while (i<j && nums[j] == nums[--j]);
                }
            }
        }
        return lists;
    }
}
