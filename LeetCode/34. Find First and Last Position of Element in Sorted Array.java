class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) return ans;

        
        // search left:
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) r = mid;
            else l = mid + 1;
        }
        if (l < nums.length && nums[l] == target) {
            ans[0] = l;
            ans[1] = l;
        }
        
        // search right:
        l = 0; r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target >= nums[mid]) l = mid+1;
            else r = mid;
        }
        if (r > 0 && r <= nums.length && nums[r-1] == target) ans[1] = r-1;
        
        return ans;
    }
}
