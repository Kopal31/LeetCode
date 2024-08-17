class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m + n];
        int ptr1 = 0, ptr2 = 0, i = 0;

        // Merge the arrays
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] <= nums2[ptr2]) {
                mergedArray[i++] = nums1[ptr1++];
            } else {
                mergedArray[i++] = nums2[ptr2++];
            }
        }

        // Add remaining elements of nums1, if any
        while (ptr1 < m) {
            mergedArray[i++] = nums1[ptr1++];
        }

        // Add remaining elements of nums2, if any
        while (ptr2 < n) {
            mergedArray[i++] = nums2[ptr2++];
        }

        // Calculate the median
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (mergedArray[mid - 1] + mergedArray[mid]) / 2.0;
        } else {
            return mergedArray[mid];
        }
    }
}
