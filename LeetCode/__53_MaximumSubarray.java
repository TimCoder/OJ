package tim.leetcode;

public class __53_MaximumSubarray {

    /*
     * dp, time O(N), space O(1).
     */
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int N = nums.length;
        int dpPre = nums[0], dp = dpPre;
        int max = dp;
        for (int i = 1; i < N; ++i) {
            dp = nums[i] + (dpPre < 0 ? 0 : dpPre);
            dpPre = dp;
            max = Math.max(dp, max);
        }

        return max;
        
    }


    /*
     * dp, time O(N), space O(N).
     * dp[i] means the maximum subarray ending with nums[i];
    /*
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < N; ++i) {
            dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            max = Math.max(dp[i], max);
        }

        return max;
        
    }
    */

    /*
     * time O(N), space O(1).
     */
    /*
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean isAllNeg = true;
        for (int i = 0; i < nums.length; ++i) {
            if (isAllNeg) {
                if (nums[i] >= 0) {
                    isAllNeg = false;
                    sum = nums[i];
                    max = sum;
                } else {
                    max = Math.max(nums[i], max);
                }
            } else {
                if (nums[i] + sum > 0) {
                    sum += nums[i];
                    max = Math.max(sum, max);
                } else {
                    sum = 0;
                }
            }
        }

        return max;

    }
    */

}
