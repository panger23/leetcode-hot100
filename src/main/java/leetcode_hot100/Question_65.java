package leetcode_hot100;

class  Question_65{
    public int[] searchRange(int[] nums, int target) {
        int start = lower_bound(nums,target) ;// >= targrt
        if(start == nums.length || nums[start] != target){ // <= target
            return new int[]{-1,-1};
        }
        int end = lower_bound(nums,target + 1) - 1; // < targrt+1
        return new int[]{start,end};
    }
    public int lower_bound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid  = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1; // 范围缩小到 [mid+1, right]
            }else{
                right = mid - 1; // 范围缩小到 [left, mid-1]
            }
        }
        return left;
    }
}