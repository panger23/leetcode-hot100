package leetcode_hot100;


class Question_64 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return lower_bound(matrix,target);
    }
    public boolean lower_bound(int[][] matrix,int target){ // 使用和搜索插入位置一样的方法
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int x = matrix[mid / n][mid % n];
            if(x == target){
                return true;
            }
            if(x < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}