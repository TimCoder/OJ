package tim.leetcode;

public class __88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < n; ++i) {
                nums1[i] = nums2[i];
            }
            return ;
        }

        if (n == 0) {
            return ;
        }

        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (p >= 0 && i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[p] = nums2[j];
                --j;
            } else {
                nums1[p] = nums1[i];
                --i;
            }
            --p;
        }

        // j must be included
        for (int k = 0; k <= j; ++k) {
            nums1[k] = nums2[k];
        }

        return ;

    }

}
