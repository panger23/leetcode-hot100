package leetcode_hot100;

public class Question_05 {
    public static void main(String[] args) {
        int[] height = {1,8,100,2,100,4,8,3,7};
        int a = maxArea(height);
        System.out.println(a);
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while (j>i){
            if (height[i] <= height[j] && i<j){
                int maxCurrent = height[i] * (j-i);
                if (maxCurrent > max){
                    max = maxCurrent;
                }
                i++;
            }
            if(height[i] > height[j] && i<j){
                int maxCurrent = height[j] * (j-i);
                if (maxCurrent > max){
                    max = maxCurrent;
                }
                j--;
            }
        }

        return max;
    }

}
