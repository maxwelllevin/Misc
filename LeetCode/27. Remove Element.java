class Solution {
    public int removeElement(int[] nums, int target) {
        // solution: use two pointers and swap elements as we traverse the array
        // let 'left' be the index from the beginning of the array
        // let 'right' be the index from the end of the array
        // traverse the array from 'left' to 'right'. At each index, swap the value at left and right-- if the value is the target.
        if (nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) swap(nums, left, right--);
            else {
                left++;
            }
        }
        return left;
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
