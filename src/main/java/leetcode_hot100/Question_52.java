package leetcode_hot100;

import java.util.ArrayList;
import java.util.List;

class Question_52 {
    private  static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}} ;// 四个方向
    public int orangesRotting(int[][] grid) {
        int row = grid.length; // 行
        int loc = grid[0].length; // 列
        int fresh = 0; // 新鲜橘子的个数
        List<int []> q = new ArrayList<>();  // 统计不新鲜橘子的坐标
        for(int i = 0;i<row;i++){
            for(int j = 0;j<loc;j++){
                if(grid[i][j] == 1){
                    fresh++; // 统计新鲜橘子的个数
                }else if(grid[i][j] == 2){
                    q.add(new int[]{i,j}); // 一开始就腐烂的橘子
                }
            }
        }
        int ans = 0;  // 记录时间分钟
        while(fresh > 0 && !q.isEmpty()){ // 如果还存在新鲜的橘子，也存在bfs中一层的腐烂的橘子
            ans++; // 经过一分钟
            List<int []> tmp = q;
            q = new ArrayList<>(); // 将q清空
            for(int[] pos : tmp){
                for(int[] d : DIRECTIONS){
                    int i = pos[0] + d[0]; //当前元素的行
                    int j = pos[1] + d[1]; //当前元素的列
                    if(i >= 0 && i<row && j>=0 && j<loc && grid[i][j] == 1) {//满足bfs可以更新的条件，新鲜橘子
                        fresh--;
                        grid[i][j] = 2;
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : ans;
    }
}