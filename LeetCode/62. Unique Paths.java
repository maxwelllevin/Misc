class Solution {
    public int uniquePaths(int m, int n) {
        double result = 1;
        for (int i = 1; i <= n - 1; i++) {
            result *= (m + i - 1.0) / i;
        }
        return (int) Math.round(result);
    }
}
