package leetcode_hot100;

import java.util.*;

public class Question_03 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,-1};
        System.out.println(longestConsecutive2(nums));
    }
    public static int longestConsecutive(int[] nums) { //自己写的（里面有排序，应该不对）
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums); //1,2,3,4,100,200
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.isEmpty()){ //避免空数组
                map.put(num,1); //(1,1)
            }else {
                if (map.containsKey(num-1)){
                    int sum = map.get(num-1);
                    sum++;
                    map.remove(num-1);
                    map.put(num,sum);
                }else {
                    if (!map.containsKey(num)){ //避免数组中重复的数字
                        map.put(num,1);
                    }
                }
            }
        }
        return Collections.max(map.values());
    }
    public static  int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) { //去重
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) { // 用哈希表查找这个数前面一个数是否存在，即num-1在序列中是否存在。存在那这个数肯定不是开头，直接跳过。
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
