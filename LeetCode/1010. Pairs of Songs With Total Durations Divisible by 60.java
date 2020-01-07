class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }
        int[] times = new int[60];
        for (int t : time) times[t]++;
        
        int numPairs = 0;        
        for (int i = 1; i < 30; i++) {
            numPairs += times[i] * times[60-i];
        }
        // Handle Pairs of 0s and Pairs of 30's
        numPairs += times[0] * (times[0] - 1) / 2;
        numPairs += times[30] * (times[30] - 1) / 2;
        
        return numPairs;
    }
}
