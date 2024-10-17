package leetcode_hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_14 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= list.get(list.size()-1)[1]){
                // 需要合并
                list.get(list.size()-1)[1] = Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }else {
                // 不需要合并，直接加入
                list.add(intervals[i]);
            }

        }
        return list.toArray(new int[list.size()][]);
    }
}
