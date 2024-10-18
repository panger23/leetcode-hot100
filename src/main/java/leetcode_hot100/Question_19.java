package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

public class Question_19 {
    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length; //行的长度3
        int col = matrix[0].length; //列的长度3
        int rowCur = 0; // 当前行为 0
        int colCur = 0; //当前列为 0
        List<Integer> result = new ArrayList<>();
        while(rowCur < row && colCur < col) { // 行，列 < 2
            int r = rowCur;
            int c = colCur;
            while (c < col){  // 第一次遍历上面的，行不变，列增加
                result.add(matrix[r][c]);
                c++;
            }
            c = col - 1; // 列恢复为2
            r++; // 行变1
            while (r < row){ // 接着遍历右边的，列不变，行增加
                result.add(matrix[r][c]);
                r++;
            }
            r = row - 1; //行恢复为2
            c--; // 列变1
            while (c >= rowCur){ // 接着遍历下面的，行不变，列减小
                result.add(matrix[r][c]);
                c--;
            }
            c = rowCur; // 列恢复为0
            r--; // 行变1
            while (r > rowCur){ // 接着遍历左边的，行减小，列不变
                result.add(matrix[r][c]);
                r--;
            }
            // 接下来开始遍历内层的矩阵
            col--;
            row--;
            rowCur++;
            colCur++;

        }

        // result的结果多了一个，需要获取前12个
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            r.add(result.get(i));
        }
        return r;
    }

}
