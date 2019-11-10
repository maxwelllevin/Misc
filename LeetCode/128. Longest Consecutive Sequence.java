import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) set.add(n);
        int max_count = 0;
        for (int start : nums) {
            if (!set.contains(start)) continue;
            set.remove(start);
            int count = 1;
            for (int left = start - 1; set.contains(left); left--, count++) set.remove(left);
            for (int right = start + 1; set.contains(right); right++, count++) set.remove(right);
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}
