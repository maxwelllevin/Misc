class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkSubBoxes(board) && checkRows(board) && checkCols(board);
    }
    
    private boolean checkSubBoxes(char[][] board) {
        for (int boxRow = 0; boxRow < 9; boxRow+=3) {
            for (int boxCol = 0; boxCol < 9; boxCol+=3) {
                int[] digits = new int[9];
                for (int i = boxRow; i < 3 + boxRow; i++) {
                    for (int j = boxCol; j < 3 + boxCol; j++) {
                        char curr = board[i][j];
                        if (curr == '.') continue;
                        if (digits[(int) (curr - '1')] != 0) return false;
                        digits[(int) (curr - '1')]++;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean checkRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            int[] digits = new int[9];
            for (int i = 0; i < 9; i++) {
                char curr = board[row][i];
                if (curr == '.') continue;
                if (digits[(int) (curr - '1')] != 0) return false;
                digits[(int) (curr - '1')]++;
            }
        }
        return true;
    }
    
    private boolean checkCols(char[][] board) {
        for (int col = 0; col < 9; col++) {
            int[] digits = new int[9];
            for (int i = 0; i < 9; i++) {
                char curr = board[i][col];
                if (curr == '.') continue;
                if (digits[(int) (curr - '1')] != 0) return false;
                digits[(int) (curr - '1')]++;
            }
        }
        return true;
    }
}
