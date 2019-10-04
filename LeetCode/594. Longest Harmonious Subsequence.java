import java.util.HashMap;
class Solution {

    public int findLHS(int[] nums) {
        //
        if (nums == null) return 0;
        HashMap<Integer, Integer> counts = new HashMap<>(nums.length);
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        int longest = 0;
        for (int key : counts.keySet()) {
            if (counts.containsKey(key + 1)) {
                longest = Math.max(longest, counts.get(key) + counts.getOrDefault(key + 1, 0));
            }
            
        }
        return longest;
    }
}
