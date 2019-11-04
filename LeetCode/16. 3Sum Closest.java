class Solution {
        
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int minDistance = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int curr_sum = nums[i] + nums[left] + nums[right];
                int curr_dist = Math.abs(target - curr_sum);
                if (curr_dist < minDistance) {
                    minDistance = curr_dist;
                    closestSum = curr_sum;
                }
                if (curr_sum < target)      left++;
                else if (curr_sum > target) right--;
                else return                 curr_sum;
            }
        }
        return closestSum;
    }
}
