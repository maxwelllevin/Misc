// TODO: Improve this by using pruning methods --> O(n^3) instead of O(n^4)

import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int m = k + 1; m < nums.length; m++) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            ArrayList<Integer> el = new ArrayList<>();
                            int[] arr = {nums[i], nums[j], nums[k], nums[m]};
                            Arrays.sort(arr);
                            int arr_hash = Arrays.toString(arr).hashCode();
                            if (seen.contains(arr_hash)) {
                                continue;
                            }
                            else {
                                seen.add(arr_hash);
                                for (int e : arr) el.add(e);
                                ans.add(el);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
