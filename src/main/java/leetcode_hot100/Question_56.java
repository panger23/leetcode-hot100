package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

public class Question_56 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) { // 迭代
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0;i < nums.length; i++){
            int size = res.size();
            for (int j = 0; j <size; j++) {
                List<Integer> current = new ArrayList<>(res.get(j));
                current.add(nums[i]);
                res.add(current);
            }
        }
        return res;
    }
}
