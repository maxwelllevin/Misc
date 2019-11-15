import java.util.ArrayList;
class Solution {
    
    // Idea:    Use a sliding window to keep track of a sorted list of elements.
    public boolean containsNearbyAlmostDuplicate(int[] nums, int K, int T) {
        if (nums == null || K <= 0 || T < 0) return false;
        
        K = Math.min(K + 1, nums.length);
        ArrayList<Long> W = new ArrayList<>();
        
        for (int i = 0; i < K; i++) W.add((long)nums[i]);
        
        Collections.sort(W);
        
        for (int i = 1; i < W.size(); i++) {
            if (W.get(i) - W.get(i-1) <= T) return true;
        }
        
        for (int i = K; i < nums.length; i++) {
            int oldIdx = find(W, nums[i - K]);
            W.remove(oldIdx);
            int idx = find(W, nums[i]);  // the index where nums[i] will be inserted
            if (idx < W.size() && W.get(idx) - nums[i] <= T) return true;  // checking to the right
            if (idx - 1 >= 0 && nums[i] - W.get(idx-1) <= T) return true;  // checking to the left
            W.add(idx, (long)nums[i]);
        }
        
        return false;
    }
    
    private int find(ArrayList<Long> W, int target) {
        int left = 0, right = W.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target < W.get(mid)) right = mid;
            else if (target > W.get(mid)) left = mid + 1;
            else return mid;
        }
        return left;
    }
}
