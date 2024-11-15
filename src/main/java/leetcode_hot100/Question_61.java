package leetcode_hot100;


import java.util.ArrayList;
import java.util.List;

class Question_61 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0); // 当前遍历的元素位置
        return res;
    }
    public void dfs(int i){
        if(i == s.length()){
            res.add(new ArrayList<>(path)); //复制 path
            return;
        }
        for(int j = i;j < s.length();j++){ // 枚举子串的结束位置
            if(isPalindrom(i,j)){
                path.add(s.substring(i,j+1));
                dfs(j+1);
                path.remove(path.size() - 1);  // 恢复现场
            }
        }
    }
    public boolean isPalindrom(int left,int right){ // 判断是否是回文串
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}