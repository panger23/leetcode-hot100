package leetcode_hot100;

public class Question_18 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        // 计算矩阵的行和列
        int row = matrix.length;
        int col = matrix[0].length;

        // 计算需要清0的行和列
        int[] rowMark = new int[row];
        int[] colMark = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0){
                    rowMark[i] = 1;
                    colMark[j] = 1;
                }
            }
        }
        // 将行清0
        for (int i = 0; i < row; i++) {
            if (rowMark[i] == 1){
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 将列清0
        for (int j=0;j<col;j++){
            if (colMark[j] == 1){
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
