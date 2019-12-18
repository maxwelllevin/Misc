public class Solution {
    public int[][] ImageSmoother(int[][] M) {
        int W = M.Length, H = M[0].Length;
        int[][] image = new int[W][];
        
        for (int r = 0; r < W; r++) {
            image[r] = new int[H];
            for (int c = 0; c < H; c++) {
                double sum = 0;
                double count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (isIn(r + i, c + j, W, H)) {
                            sum += M[r + i][c + j];
                            count++;
                        }
                    }
                }
                image[r][c] = (int) Math.Floor(sum / count);
            }
        }
        return image;
    }
    
    private bool isIn (int r, int c, int W, int H) {
        return (0 <= r && r < W) && (0 <= c && c < H);
    }
}
