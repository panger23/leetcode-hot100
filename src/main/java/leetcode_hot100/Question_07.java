package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

public class Question_07 {
    public static void main(String[] args) {
//        int[] height =  {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height =  {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int h  : height) {
            if (h > max){
                max = h;
            }
        }
        int sum = 0;
        for (int i = max; i >0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < height.length; j++) {
                if ( height[j] >= i ){
                    list.add(j);
                }
            }
            if (list.size() != 1){
                for (int k = 0; k < list.size()-1; k++) {
                    sum = sum + list.get(k+1) - list.get(k) - 1;
                }
            }
        }
        return sum;
    }
}
