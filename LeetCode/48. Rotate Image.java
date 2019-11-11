class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int layers = N / 2;  // N=4 -> layers=2, N=5 -> layers=2; the center doesn't rotate if N is odd
        for (int i = 0; i < layers; i++) {
            rotateLayer(matrix, i);
        }
    }
    
    /*
    ** Performs a rotation on one layer in the matrix.
    ** Layers are counted from the outside - in.
    ** @param {int[][]} matrix  - the N by N matrix of integers
    ** @param {int} layer       - the mth layer from the outside-in, 0-based.
    */
    private void rotateLayer(int[][] matrix, int layer) {
        if (layer == matrix.length / 2) return;
        int N = matrix.length;
        int start = layer;
        int end = N - layer;  // 0th layer is the outside, 1st layer is offset by 1 from the outside, etc
        for (int i = 0; i < end - start - 1; i++) {  // i goes from 0 to the length of the side - 1. (-1 because sides share corners)
            // positions considered:
            int r1 = start,         c1 = start + i;     // top row 
            int r2 = start + i,     c2 = end - 1;       // right col
            int r3 = end - 1,       c3 = end - 1 - i;   // bottom row
            int r4 = end - 1 - i,   c4 = start;         // left col            
            int temp = matrix[r1][c1];
            matrix[r1][c1] = matrix[r4][c4];
            matrix[r4][c4] = matrix[r3][c3];
            matrix[r3][c3] = matrix[r2][c2];
            matrix[r2][c2] = temp;
        }
    }
}
