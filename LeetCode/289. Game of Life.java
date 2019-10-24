class Solution {
    public void gameOfLife(int[][] board) {
        int[][] copy = makeCopy(board);
        int R = board.length;
        int C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int w = (j - 1 >= 0 && copy[i][j - 1] == 1) ? 1 : 0;
                int e = (j + 1 < C  && copy[i][j + 1] == 1) ? 1 : 0;
                int n = (i - 1 >= 0 && copy[i - 1][j] == 1) ? 1 : 0;
                int s = (i + 1 < R  && copy[i + 1][j] == 1) ? 1 : 0;
                int nw = (j != 0        && i != 0       && copy[i - 1][j - 1] == 1) ? 1 : 0;
                int ne = (j != C - 1    && i != 0       && copy[i - 1][j + 1] == 1) ? 1 : 0;
                int sw = (j != 0        && i != R - 1   && copy[i + 1][j - 1] == 1) ? 1 : 0;
                int se = (j != C - 1    && i != R - 1   && copy[i + 1][j + 1] == 1) ? 1 : 0;
                int live_neighbors = n + e + s + w + nw + ne + sw + se;
                if (copy[i][j] == 1 && !(2 <= live_neighbors && live_neighbors <= 3)) board[i][j] = 0;
                else if (copy[i][j] == 0 && live_neighbors == 3) board[i][j] = 1;
            }
        }
    }
    
    private int[][] makeCopy(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[i][j] = A[i][j];
            }
        }
        return B;
    }
}
