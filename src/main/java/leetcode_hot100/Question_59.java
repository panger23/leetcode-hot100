package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

class Question_59 {
    static List<String>res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }
    public static List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }
    public  static void dfs(int left,int right,String cur){
        if(left == 0 && right == 0){ // 左右括号都不剩余了，递归终止
            res.add(cur);
            return;
        }
        if(left > 0){ // 如果左括号还剩余的话，可以拼接左括号
            dfs(left-1,right,cur+"(");
        }
        if(right > left){ // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left,right-1,cur+")");
        }
    }
}