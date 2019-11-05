class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int closest = -1;
        int i = 0, j = A.length -1;
        while (i < j) {
            if (A[i] + A[j] < K) {
                closest = Math.max(closest, A[i] + A[j]);
                i++;
            }
            else j--;
        }
        return closest;
    }
}
