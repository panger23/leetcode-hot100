package leetcode_hot100;

public class Question_21 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix2(matrix,target));
    }
    public static  boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        // 矩阵从左下角开始遍历
        // 模拟二叉树 树形结构
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
    // 我在考虑，是不是可以从右上角开始遍历树形结构呢？
    public static  boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        // 矩阵从右上角角开始遍历
        // 模拟二叉树 树形结构
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return true;
        }
        return false;
    }
}
