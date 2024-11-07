package leetcode_hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Question_53 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses]; //入度表 indegrees
        List<List<Integer>> adjacency = new ArrayList<>(); //邻接表,统计每个课程的后续课程
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            adjacency.add(new ArrayList<>()); // 先建立初始化的临接表
        }
        for(int[] cp : prerequisites){
            indegrees[cp[0]]++;  // 统计每个课程有多少个前驱课程，统计入度表
            adjacency.get(cp[1]).add(cp[0]); // 建立临接表
        }
        // 获得所有入度为0的课程
        for(int i = 0;i<numCourses;i++){
            if(indegrees[i] == 0) queue.add(i); // 将入度为0的课程的编号加入队列
        }
        // BFS
        while(!queue.isEmpty()){
            int pre = queue.poll(); // 出队
            numCourses--; //已经学完一个课程
            for(int cur : adjacency.get(pre)){ // 遍历pre课程的每一个后续课程
                indegrees[cur]--;
                if(indegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }
}