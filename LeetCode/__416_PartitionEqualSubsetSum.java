package tim.leetcode;

public class __416_PartionEqualSubsetSum {

    /*
     * Time : O(N * M), M = sum / 2, Space : O(N * M).
     * using time : 65 ms.
     */
    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        //0, 1背包问题放满背包的方法数的简化版。
        //dp[i][j] 前i个物品放到容量为j的背包里，有多少种方法。

        boolean[][] dp = new boolean[N + 1][sum + 1];
        dp[0][0] = true;
        for (int j = 1; j < sum + 1; ++j) { 
            dp[0][j] = false;
        }

        for (int i = 1; i < N + 1; ++i) {
            dp[i][0] = false;
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < sum + 1; ++j) { 
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];

    }

    /*
     * TLE.
     * Time : O(2 ^ N), Space : O(N).
     */ 
    /*
    private int N;

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        //求是否存在子序列的和为sum / 2.

        return partition(nums, 0, sum / 2);

    }

    public boolean partition(int[] a, int i, int target) {

        if (target == 0) {
            return true;
        }

        if (i < N - 1) {
            return partition(a, i + 1, target) || partition(a, i + 1, target - a[i]);
        }

        return false;
    }
    */

}
