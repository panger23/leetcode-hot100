package leetcode_hot100;

import java.util.*;

public class Question_09 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s,p);
        System.out.println(list);
    }
    public static  List<Integer> findAnagrams(String s, String p) {
        LinkedList<Character> listt = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<p.length();i++){
            listt.add(p.charAt(i));
        }
        int n = p.length();
        for(int l=0,r=n+l-1;r<s.length();r++){
            LinkedList<Character> listt2 = new LinkedList<>();
            for(int i = l;i<=r;i++){
                listt2.add(s.charAt(i));
            }
            Collections.sort(listt2);
            if(listt2.equals(listt)){
                list.add(l);
            }
            l++;
        }
        return list;
    }
}
