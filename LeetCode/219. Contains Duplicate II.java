import java.util.HashSet;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < k + 1 && i < nums.length; i++) {
            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
        }
        for (int i = k + 1; i < nums.length; i++) {
            window.remove(nums[i - k - 1]);
            if (window.contains(nums[i])) return true;
            window.add(nums[i]);
        }
        return false;   
    }
}
