package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

class Question_58 {
    List<List<Integer>> res = new ArrayList<>(); // 结果集合
    List<Integer> cur = new ArrayList<>(); // 当前满足条件的集合
    int[] candidates;
    int length;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.length = candidates.length;
        dfs(0,target); // 递归
        return res;
    }
    public void dfs(int x,int target){
        if(x == length || target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        // 不选这个元素
        dfs(x + 1,target);

        // 选这个元素
        cur.add(candidates[x]); // 可以选几个，如果可以选，继续执行dfs(x)
        dfs(x,target-candidates[x]);
        cur.remove(cur.size() - 1);

    }
}