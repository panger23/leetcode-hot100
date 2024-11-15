package leetcode_hot100;


class Question_63 {
    public int searchInsert(int[] nums, int target) {
        return lower_bound(nums,target); // 求nums中第一个大于等于target的数的下标
    }
    public int lower_bound(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){ // 闭区间为[left, right]
            int mid = left + (right - left)/2; //求中点
            if(nums[mid] < target)
                left  = mid + 1;// [mid+1, right]
            else{
                right = mid - 1; // [left, mid - 1 ]
            }
        }
        return left;
    }
}