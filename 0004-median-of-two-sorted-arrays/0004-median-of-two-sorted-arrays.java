class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j-1] > nums1[i]){
                iMin = i + 1; 
            }
            else if (i > 0 && nums1[i-1] > nums2[j]) {
                iMax = i - 1; 
            }
            else {
                double maxLeft;
                if (i == 0) { maxLeft = (double)nums2[j-1]; }
                else if (j == 0) { maxLeft = (double)nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ((m + n) % 2 == 1) { return maxLeft; }

                double minRight;
                if (i == m) { minRight = (double)nums2[j]; }
                else if (j == n) { minRight = (double)nums1[i]; }
                else { minRight = Math.min(nums1[i], nums2[j]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}