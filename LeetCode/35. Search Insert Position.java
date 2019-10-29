class Solution {
    
    // Should be just binary search problem
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length);
    }
    
    
    /**
    ** Binary Search algorithm which returns the index where the target should be.
    ** {int} left: the lower index (inclusive) to search from
    ** {int} right: the upper index (exclusive) to search until
    */
    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left == right) return left;
        int mid = (left + right) / 2;
        if (target < nums[mid]) return binarySearch(nums, target, left, mid);
        if (target > nums[mid]) return binarySearch(nums, target, mid + 1, right);
        return mid;        
    }
}
