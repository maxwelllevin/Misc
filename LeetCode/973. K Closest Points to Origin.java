class Solution {

    public int[][] kClosest(int[][] points, int K) {
        
        // Max-heap of the minimum elements
        PriorityQueue<int []> closest = new PriorityQueue<int []>((point1, point2) -> {
            double dist1 = Math.sqrt(point1[0]*point1[0] + point1[1]*point1[1] + 0.0);
            double dist2 = Math.sqrt(point2[0]*point2[0] + point2[1]*point2[1] + 0.0);
            if (dist1 == dist2) return 0;
            if (dist1 > dist2) return -1;
            return 1;
        });
        
        // Add points to the heap while maintaining the heap size
        for (int i = 0; i < points.length; i++) {
            if (closest.size() == K) {
                int[] point1 = closest.remove();
                int[] point2 = points[i];
                closest.add(closer(point1, point2));
            }
            else closest.add(points[i]);
        }
        
        // Translate the heap into an answer
        int[][] ans = new int[K][2];
        for (int i = K-1; i >= 0 ; i--) {
            ans[i] = closest.remove();
        }
        return ans;
    }
    
    /**
    *  Returns the point closer to the origin.
    */
    private int[] closer(int[] point1, int[] point2) {
        double dist1 = Math.sqrt(point1[0]*point1[0] + point1[1]*point1[1] + 0.0);
        double dist2 = Math.sqrt(point2[0]*point2[0] + point2[1]*point2[1] + 0.0);
        return (dist1 < dist2) ? point1 : point2;
    }
    
}
