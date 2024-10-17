package leetcode_hot100;

import java.util.Arrays;

public class Question_04 {
    public static void main(String[] args) {
       int[] nums = {0,0,1};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static  void moveZeroes(int[] nums) { // 遍历两次
        int j = 0;
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static  void moveZeroes2(int[] nums) { // 遍历1次
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
