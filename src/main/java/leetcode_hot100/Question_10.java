package leetcode_hot100;

import java.util.LinkedList;
import java.util.List;

public class Question_10 {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int k = 0;
        int r = subarraySum(nums,k);
        System.out.println(r);
    }
    public static  int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            List<Integer> list = new LinkedList<>();
            for(int j = i;j<nums.length;j++){
                list.add(nums[j]);
                if(sum(list) ==  k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static  int sum(List<Integer> list){
        int n = 0;
        for(int i=0;i<list.size();i++){
            n = n + list.get(i);
        }
        return n;
    }
}
