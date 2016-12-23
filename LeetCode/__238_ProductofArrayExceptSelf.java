package tim.leetcode;

public class __238_ProductofArrayExceptSelf {
    /*
     * Time : O(N), Space : O(1).
     * combine x'left and x'right to get result.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; ++i) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
