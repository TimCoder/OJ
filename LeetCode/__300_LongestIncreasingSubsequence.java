package tim.leetcode;

import java.util.Arrays;

public class __300_LongestIncreasingSubsequence {
    /*
     * Time: O(N * logN), Space: O(N).
     * Using Arrays.binarySearch(int[], int fromIndex, int toIndex, int key).
     */
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        //dp[i] store the length i＋1 Subsquence' smallest ending value.
        int[] dp = new int[N];
        int len = 0;
        for (int x : nums) {
            int index = Arrays.binarySearch(dp, 0, len, x);
            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = x;
            if (index == len) {
                ++len;
            }
        }

        return len;
    }
    /*
     * Time: O(N * logN), Space: O(N).
     */
    /*
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        //dp[i] store the length i＋1 Subsquence' smallest ending value.
        int[] dp = new int[N];
        dp[0] = nums[0];
        //left and right are the border in dp.
        int left = 0;
        int right = 0; 
        int max = 1;
        for (int i = 1; i < N; ++i) {
            int l = left;
            int r = right;
            while(l <= r) {
                int m = l + (r - l) / 2;
                if (nums[i] > dp[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(l, right);
            dp[l] = nums[i];
            max = Math.max(l + 1, max);
        }

        return max;
    }
    */
    
    /*
     * Time: O(N ^ 2), Space: O(N).
     */
    /*
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int N = nums.length;
        //以i为结尾的子序列（必须包含i）中的最大增长子序列的值
        int[] dp = new int[N];
        dp[0] = 1;
        System.out.print(dp[0] + " ");
        int max = dp[0];
        for (int i = 1; i < N; ++i) {
            dp[i] = 1;
            for (int j = i; j > 0; --j) {
                if (nums[i] > nums[j - 1]) {
                    dp[i] = Math.max(dp[j - 1] + 1, dp[i]);
                } 
            }
            System.out.print(dp[i] + " ");
            max = Math.max(dp[i], max);
        }
        
        return max;
        
    }
    */
    
}
