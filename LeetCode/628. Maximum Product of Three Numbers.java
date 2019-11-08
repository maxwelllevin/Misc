class Solution {
    public int maximumProduct(int[] nums) {
        int[] maxes = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int n : nums) updateMinsAndMaxes(n, mins, maxes);
        if (mins[0] * mins[1] > maxes[0] * maxes[1]) return mins[0] * mins[1] * maxes[2];
        return maxes[0] * maxes[1] * maxes[2];
    }
    
    /**
    ** Updates the minimums array and maximums array with the given integer.
    ** Both mins and maxes should be sorted in ascending order.
    */
    private void updateMinsAndMaxes(int n, int[] mins, int[] maxes) {
        if (n <= mins[0]) { // Smallest
            mins[1] = mins[0];
            mins[0] = n;
        }
        else if (n < mins[1]) mins[1] = n;
        
        if (n >= maxes[2]) {  // Largest
            maxes[0] = maxes[1]; maxes[1] = maxes[2];
            maxes[2] = n;
        }
        else if (n >= maxes[1]) {
            maxes[0] = maxes[1];
            maxes[1] = n;
        }
        else if (n > maxes[0]) maxes[0] = n;
    }
}
