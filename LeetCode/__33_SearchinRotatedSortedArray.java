package tim.leetcode;

public class __33_SearchinRotatedSortedArray {
    /*
     * Time : O (log N).
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
                if (nums[m] < head && head <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] >= head && head > target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
