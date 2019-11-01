import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder(int[][] M) {
        if (M == null || M.length == 0) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>(M.length * M[0].length);
        
        // Spiral Dimensions
        int C = M[0].length;
        int R = M.length;
        
        // Matrix position
        int i = 0, j = 0;
        
        // Direction to add in
        boolean reverse = false;
        
        while (R > 0 && C > 0) {
            // assume i, j is the current position, unseen previously
            if (!reverse) {  // left -> right, up -> down
                for (int c = 0; c < C; c++) {
                    list.add(M[i][j + c]);
                }
                i++; C--; j+=C;
                for (int r = 0; r < R - 1; r++) {
                    list.add(M[i + r][j]);
                }
                j--; R--; i+=R-1;
                reverse = true;
            }
            else {  // right -> left, down -> up
                for(int c = 0; c < C; c++) {
                    list.add(M[i][j - c]);
                }
                i--; C--; j-=C;
                for (int r = 0; r < R - 1; r++) {
                    list.add(M[i - r][j]);
                }
                j++; R--; i-=(R - 1);
                reverse = false;
            }
        }
        return list;
    }
    
}
