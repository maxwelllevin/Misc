class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        long sum = (N * (N + 1)) / 2;
        for (int num : nums) sum -= num;
        return (int) sum;
    }
}
