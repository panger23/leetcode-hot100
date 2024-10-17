package leetcode_hot100;


import java.util.HashMap;
import java.util.Map;

public class Question_01 {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        int[] a = twoSum3(nums, target);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                   return new int[] {i, j};
                }
            }
        }
       throw new IllegalArgumentException("没有找到");
    }
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c) && map.get(c)!=i){
                return new int[]{i,map.get(c)};
            }
        }
        throw new IllegalArgumentException("没找到");
    }
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有找到");
    }
}
