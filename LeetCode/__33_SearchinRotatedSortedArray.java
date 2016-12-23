package tim.leetcode;

public class __33_SearchinRotatedSortedArray {
    /*
     * Test Case : 4,5,6,7,0,1,2.
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        int head = nums[0];
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                if (nums[m] >= head) {
                    l = m + 1;
                } else {
                    if (head <= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if (nums[m] >= head) {
                    if (head <= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
