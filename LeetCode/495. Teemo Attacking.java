class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int time = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            time += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return time;
    }
}
