package tim.leetcode;

public class __167_TwoSumII_Inputarrayissorted {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
