class Solution {
    public int[][] generateMatrix(int n) {
        int[][] M = new int[n][n];
        
        // Spiral Dimensions
        int C = M[0].length;
        int R = M.length;  // rid -1, replace R-- with --R
        
        // Matrix position
        int i = 0, j = 0;
        
        // Direction to add in
        boolean reverse = false;
        
        // Number to populate matrix with
        int num = 1;
        
        while (R > 0 && C > 0) {
            // assume i, j is the current position, unseen previously
            if (!reverse) {  // left -> right, up -> down
                for (int c = 0; c < C; c++) {
                    // System.out.println("(" + i + ", " + (j + c) + ")");
                    M[i][j + c] = num++;
                }
                i++; C--; j+=C;
                for (int r = 0; r < R - 1; r++) {
                    // System.out.println("(" + (i + r) + ", " + j + ")");
                    M[i + r][j] = num++;
                }
                j--; R--; i+=R-1;
                reverse = true;
            }
            else {  // right -> left, down -> up
                for(int c = 0; c < C; c++) {
                    // System.out.println("(" + i + ", " + (j - c) + ")");
                    M[i][j - c] = num++;
                }
                i--; C--; j-=C;
                for (int r = 0; r < R - 1; r++) {
                    // System.out.println("(" + (i - r) + ", " + j + ")");
                    M[i - r][j] = num++;
                }
                j++; R--; i-=(R - 1);
                reverse = false;
            }
        }
        return M;
    }
}
