class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int K) {
        int count = 0;
        int left = 0, right = 0, N = nums.length;
        double window = nums[0];
        
        while (left < N && right < N) {
            if (window < K) {
                count += right - left + 1;
                right++;
                if (right == N) break;
                window *= nums[right];
            }
            else {
                window /= nums[left];
                left++;
            }
            
        }
        
        return count;
    }
}
