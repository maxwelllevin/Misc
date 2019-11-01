import java.util.ArrayList;
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        
        // Sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] - interval2[0] != 0) return interval1[0] - interval2[0];
                return interval1[1] - interval2[1];
            }
        });
        
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            if (intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
            else {
                result.add(intervals[i]);
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}
