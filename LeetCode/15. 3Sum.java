class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[i] + nums[lo] + nums[hi] == 0) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if (nums[i] + nums[lo] + nums[hi] < 0) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
