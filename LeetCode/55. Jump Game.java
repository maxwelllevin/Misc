class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if (maxIndex < i) return false;
            if (maxIndex >= nums.length - 1) return true;
            maxIndex = (i + nums[i]) > maxIndex ? i + nums[i] : maxIndex; // greedy
        }
        return true;
    }
}
