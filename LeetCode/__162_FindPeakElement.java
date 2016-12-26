package tim.leetcode;

public class __162_FindPeakElement {
    /*
     * Time : O(log N), Space : O(1).
     * nums[-1] < nums[0] ... nums[i - 1] ? nums[i] ? nums[i + 1] ... nums[n - 1] > nums[n]
     * 在nums[0]到nums[n - 1]之间找第一个>号:
     *    若找到，返回>号前面的位置; 
     *    若未找到，返回n - 1。
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1; 
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    /*
     * Time : O(N), Space : O(1).
     * nums[-1] < nums[0] ... nums[i - 1] ? nums[i] ? nums[i + 1] ... nums[n - 1] > nums[n]
     * 在nums[0]到nums[n - 1]之间找第一个>号:
     *    若找到，返回>号前面的位置; 
     *    若未找到，返回n - 1。
     */
    /*
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i - 1] > nums[i]]) {
                return i - 1;
            }
        }

        return nums.length - 1;
    }
    */
}
