package leetcode_hot100;

public class Question_20 {
    public static void main(String[] args) {
        int[][]  matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
     }
    public static void rotate(int[][] matrix) {
      int n = matrix.length;
        // 矩阵顺时针旋转 90º 后，可找到以下规律：
        //「第 i 行」元素旋转到「第 n−1−i 列」元素；  //那么第j列是第n-1-j行旋转的
        //「第 j 列」元素旋转到「第 j 行」元素；// 那么第i行是第i列旋转的

        // 如果n=4，n/2 = 2，（n+1)/2 = 2。
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
