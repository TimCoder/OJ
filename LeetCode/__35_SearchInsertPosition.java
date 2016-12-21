package tim.leetcode;

public class __35_SearchInsertPosition {
    /*
     * Time : O(log N).
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] == target) { 
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    /*
     * Time : O(N).
     */
    /*
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }
    */
}
