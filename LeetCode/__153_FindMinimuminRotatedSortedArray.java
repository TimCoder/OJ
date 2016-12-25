package tim.leetcode;

public class __153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (m == 0) {
                break;
            }

            if(nums[m] < nums[m - 1]) {
                return nums[m];
            } else {
                if (nums[m] >= nums[0]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return nums[1] < nums[0] ? nums[1] : nums[0];
    }
}
