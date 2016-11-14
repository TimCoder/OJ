package tim.leetcode;

public class __264_UglyNumberII {

    public int nthUglyNumber(int n) {

        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int mult2 = 0;
        int mult3 = 0;
        int mult5 = 0;
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.min(dp[mult2] * 2, Math.min(dp[mult3] * 3, dp[mult5] * 5)); 
            if (dp[mult2] * 2 == dp[i]) {
                ++mult2;
            }
            if (dp[mult3] * 3 == dp[i]) {
                ++mult3;
            }
            if (dp[mult5] * 5 == dp[i]) {
                ++mult5;
            }
        }

        return dp[n - 1];

    }

}
