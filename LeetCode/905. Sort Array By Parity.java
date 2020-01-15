class Solution {
    public int[] sortArrayByParity(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            if (A[start] % 2 == 0) {
                start++;
                continue;
            }
            if (A[end] % 2 == 1) {
                end--;
                continue;
            }
            int temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
        return A;
    }
}
