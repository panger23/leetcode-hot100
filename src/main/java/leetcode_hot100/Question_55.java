package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

class Question_55 {
    List<Integer> nums;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>(); // res为最终结果
        this.nums = new ArrayList<>(); // 将数组转换为列表
        for(int num : nums){
            this.nums.add(num);
        }
        dfs(0); //当前固定位 0
        return res;
    }
    public void dfs(int x){
        if(x == nums.size() -1) {
            res.add(new ArrayList<>(nums));
            return ;
        }
        for(int i = x;i<nums.size();i++){ // 不断固定第i位为开头，一开始固定i为第0位，后面固定i为第1位，类推
            swap(i,x); // 交换 将 nums[i] 固定在第 x 位
            dfs(x+1); // 递归 开启固定第 x + 1 位元素
            swap(x,i);// 回溯
        }
    }
    public void swap(int a,int b){
        int temp = nums.get(a);
        nums.set(a,nums.get(b));
        nums.set(b,temp);
    }
}