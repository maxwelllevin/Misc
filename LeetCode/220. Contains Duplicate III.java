// Updated: Now uses solution obtained after reading through the discussion board. 
public class Solution {
    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` but we need `-3 / 5 = -1`.
    private long getBucket(long x, long bucketSize) {
        if (x < 0) return (x + 1) / bucketSize - 1;
        return x / bucketSize;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || t < 0 || k <= 0) return false;
        Map<Long, Long> buckets = new HashMap<>();
        long T = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getBucket(nums[i], T);
            if (buckets.containsKey(m)) return true;
            if (buckets.containsKey(m - 1) && Math.abs(nums[i] - buckets.get(m - 1)) < T) return true;
            if (buckets.containsKey(m + 1) && Math.abs(nums[i] - buckets.get(m + 1)) < T) return true;
            buckets.put(m, (long)nums[i]);
            if (i >= k) buckets.remove(getBucket(nums[i - k], T));
        }
        return false;
    }
}
