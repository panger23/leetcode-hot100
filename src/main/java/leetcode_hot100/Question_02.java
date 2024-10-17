package leetcode_hot100;

import java.util.*;

public class Question_02 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] strs) { //自己写的

        Map<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) { //或者for(String s : strs)
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars); //每个单词字符排序
            String s = new String(chars);
            if (!map.containsKey(s)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s,list);
            }else {
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s,list);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (String s : map.keySet()) {
            lists.add(map.get(s));
        }
        return lists;
    }
}
