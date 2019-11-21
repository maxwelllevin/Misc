class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int mostOverlap = 0;
        
        for (int shiftX = -N + 1; shiftX < N; shiftX++) {
            for (int shiftY = -N + 1; shiftY < N; shiftY++) {
                mostOverlap = Math.max(mostOverlap, calculateOverlap(A, B, shiftX, shiftY));
            }
        }
        
        return mostOverlap;
    }
    
    private int calculateOverlap(int[][] RED, int[][] BLUE, int shiftX, int shiftY) {
        int overlap = 0;
        int N = RED.length;
        int sRx = Math.max(0, -shiftX), sRy = Math.max(0, -shiftY);
        int fRx = Math.min(N, N - shiftX), fRy = Math.min(N, N - shiftY);
        int sBx = Math.max(0, shiftX), sBy = Math.max(0, shiftY);
        int fBx = Math.min(N, N + shiftX), fBy = Math.min(N, N + shiftY);
        
        for (int rx = sRx, bx = sBx; rx < fRx; rx++, bx++) {
            for (int ry = sRy, by = sBy; ry < fRy; ry++, by++) {
                if (RED[rx][ry] == 1 && BLUE[bx][by] == 1) overlap++;
            }
        }
        
        return overlap;
    }
}
