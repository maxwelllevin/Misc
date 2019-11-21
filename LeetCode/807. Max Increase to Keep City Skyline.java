class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int R = grid.length, C = grid[0].length;
        
        // Find max heights for the NS and EW skylines
        int[] maxInRows = new int[R], maxInCols = new int[C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                maxInRows[r] = Math.max(maxInRows[r], grid[r][c]);
                maxInCols[c] = Math.max(maxInCols[c], grid[r][c]);
            }
        }
        
        // Calculate total possible increase in height
        int increase = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                increase += Math.min(maxInRows[r], maxInCols[c]) - grid[r][c];
            }
        }
        
        return increase;
    }
}
