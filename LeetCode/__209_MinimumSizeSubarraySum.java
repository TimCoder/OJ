package tim.leetcode;

public class __209_MinimumSizeSubarraySum {
    /*
     * Time : O(N), Space : O(1).
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(j - i + 1, res);
                sum -= nums[i++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /*
     * TLE. (Time Limit Exceeded)
     * Time : O(N * log N), Space : O(1).
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums[0] >= s) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) { 
            sum[i] = nums[i] + sum[i - 1];
        }

        //Sub array ends with i.(included i).
        for (int i = 1; i < nums.length; ++i) {
            if (sum[i] >= s) {
                int l = 0, r = i;
                while (l <= r) {
                    int m = l + ((r - l) >> 1);
                    if (sum[i] - sum[m] + nums[m] >= s) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                // consider when the while loop finish, r < l is true.
                // before loop finish, last time:
                // when l == r == m
                //     if (sum[i] - sum[m] + nums[m] >= s), l = r + 1. nums[r ~ i] >= s, nums[r + 1 ~ i] < s.
                //     else, r = r - 1. nums[r + 1 ~ i] < s, nums[r ~ i] >=s.
                // so r is biggest start index with end index i that constructs sub array's sum >= s. 
                int start = r;
                res = Math.min(i - start + 1, res);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /*
     * TLE. (Time Limit Exceeded)
     * Time : O(N ^ 2), Space : O(1).
     */
    /*
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int len, sum;
        for (int i = 0; i < nums.length; ++i) { 
            sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum >= s) {
                    len = i - j + 1;
                    res = Math.min(len, res);
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
    */
}
