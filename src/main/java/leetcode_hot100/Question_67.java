package leetcode_hot100;

class Question_67 {
    // 和最后一个数比大小，简洁二分
    public int findMin(int[] nums) {
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
        if(left == nums.length) return nums[right]; // 越界处理，因为返回的是可以插入的位置，有可能为nums.length
        return nums[left];
    }
}