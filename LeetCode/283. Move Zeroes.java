class Solution {
    public void moveZeroes(int[] nums) {
        int intsIdx = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[intsIdx] = nums[i];
                intsIdx++;
                i++;
            }
            else {
                i++;
            }
        }
        while (intsIdx < nums.length) nums[intsIdx++] = 0;
    }
}
