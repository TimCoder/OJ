package tim.leetcode;

public class __153_FindMinimuminRotatedSortedArray {
    /*
     * Time : O(log N)
     * 在nums[0]到nums[n - 1]之间找>号:
     *   若找到，返回>号后面的元素值; 
     *   若未找到，返回nums[0]。
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            } else {
                if (nums[m] == nums[0]) {
                    return nums[m];
                } else if (nums[m] < nums[0]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }

        return nums[0];
    }
    /*
     * Time : O(log N)
     */
    /*
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
    */
}
