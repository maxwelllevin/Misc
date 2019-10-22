class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] n1 = new int[m];
        for (int i = 0; i < m; i++) n1[i] = nums1[i];
        
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (n1[i] <= nums2[j]) nums1[k++] = n1[i++];
            else if (n1[i] > nums2[j]) nums1[k++] = nums2[j++];
        }
        while (i < m) nums1[k++] = n1[i++];
        while (j < n) nums1[k++] = nums2[j++];
    }
}
