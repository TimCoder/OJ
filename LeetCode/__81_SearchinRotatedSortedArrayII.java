package tim.leetcode;

public class __81_SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int l = 0, r = nums.length - 1;
        int head = nums[0];
        while (l < r && nums[r] == head) {
            --r;
        }
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) {
                return true;
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

        return false;
    }
}
