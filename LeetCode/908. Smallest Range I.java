class Solution {
    public int smallestRangeI(int[] A, int K) {
        if (A.length < 2) return 0;
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) min = A[i];
            if (A[i] > max) max = A[i];
        }
        return Math.max(max - min - 2 * K, 0);
    }
}
