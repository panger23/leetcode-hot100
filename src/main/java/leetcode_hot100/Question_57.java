package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

class Question_57 {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    char[] path;
    char[] digit;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>(); // 如果digits长度为0，就返回空数组
        int n  = digits.length(); // 求digits的长度
        this.path = new char[n]; // path固定为n
        this.digit = digits.toCharArray(); // 将digits变为字符数组
        dfs(0); // 递归digit的第一个字符
        return res;
    }
    public void dfs(int x){
        if(x == digit.length){ // 边界：如果递归到digit的最后一个字符，就加入结果集合
            res.add(new String(path));
            return;
        }
        for(char c : MAPPING[digit[x]-'0'].toCharArray()){ // 遍历电话号码MAPPING的每个字符
            path[x] = c;
            dfs(x+1);
        }
    }

}