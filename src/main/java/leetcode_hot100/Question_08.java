package leetcode_hot100;

import java.util.HashSet;
import java.util.Set;

public class Question_08 {
    public static void main(String[] args) {
        String s = "abc abcd abcde";
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
    }

    public static  int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int max = 0;

        int i = 0,j = 1;
        Set<Character> set = new HashSet<>();
        set.add(charArray[0]);
        for (int k = 0; k < charArray.length; k++) {
            int maxCurrent = 0;
            if (!set.contains(charArray[j])){
                j++;
            }
            maxCurrent = j-i;
            if (max < maxCurrent){
                max = maxCurrent;
            }
            if (set.contains(charArray[j])){
                i++;
            }
        }

        return max;
    }
}
