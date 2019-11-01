import java.util.ArrayList;
class Solution {
    
    // Strategy:
    // while no overlap, add the current to the result list
    // add the newInterval to result list
    // while overlap, merge the newInterval with current
    // while no overlap, add current to result list
    // return result list as array
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> results = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && !hasOverlap(intervals[i], newInterval)) {
            if (newInterval[1] < intervals[i][0]) {
                break;
            }
            results.add(intervals[i]);
            i++;
        }
        int m = results.size();
        results.add(newInterval);
        while (i < intervals.length && hasOverlap(intervals[i], results.get(m))) {
            results.get(m)[0] = Math.min(intervals[i][0], results.get(m)[0]);
            results.get(m)[1] = Math.max(intervals[i][1], results.get(m)[1]);
            i++;
        }
        while (i < intervals.length) {
            results.add(intervals[i]);
            i++;
        }
        return results.toArray(new int[results.size()][2]);
    }
    
    private boolean hasOverlap(int[] range1, int[] range2) {
        int a = range1[0], b = range1[1];
        int c = range2[0], d = range2[1];
        return !(b < c || a > d);
    }
    
    
}
