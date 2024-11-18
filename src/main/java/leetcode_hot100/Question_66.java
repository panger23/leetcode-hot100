package leetcode_hot100;

class Question_66 {
    public int search(int[] nums, int target) {
        int i = findMin(nums,target); // //查找数组中最小值的下标
        if(nums[i] == target) return i; // 如果最小值下标就是target，直接返回。
        if(target > nums[nums.length - 1]){ //在区间[0,i - 1]中找
            return lower_bound(nums,0,i-1,target);
        }
        // 否则在区间[i,nums.length - 1]中找
        return lower_bound(nums,i,nums.length-1,target);
    }
    public int lower_bound(int[] nums,int left,int right,int target){ // 在有序数组中找target
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }
    //查找数组中最小值的下标
    public int findMin(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[nums.length - 1]){
                //那么nums[mid]一定在第二段，或者只有一段。nums[mid]要么是最小值，要么在最小值右边。
                right = mid - 1; // 范围缩小到[left,mid - 1]
            }else{
                // 那么nums[mid]一定在第一段，最小值在第二段，所以nums[mid]一定在最小值的左边
                left = mid + 1; // 范围缩小到[mid + 1,right]
            }
        }
        if(left == nums.length) return right; // 越界处理，因为返回的是可以插入的位置，有可能为nums.length
        return left;
    }
}