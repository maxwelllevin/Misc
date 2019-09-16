class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Position in nums1
        int i = 0;
        
        // Position in nums2
        int j = 0;
        
        // Position in arr
        int k = 0;
        
        // Merge the two arrays
        int[] arr = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            }
            else {  // nums2[j] < nums1[i]
                arr[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        
        double med = arr[(arr.length - 1) / 2]; // index of center or left-leaning
        
        if (arr.length % 2 == 0){
            double medR = arr[(arr.length-1)/2 + 1];
            med = (med + medR) / 2;
        }
        
        return med;
    }
}
