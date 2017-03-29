package tim.DP;

public class Unique Paths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int[] dpPre = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dpPre[i] = 1;
        }

        for (int i = 1; i < m; ++i) {
            dp[0] = dpPre[0];
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j - 1] + dpPre[j];
            }
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }

        return dpPre[n - 1];
    }
}
