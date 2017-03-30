package tim.DP;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 0 || obstacleGrid[0].length < 0) {
            return -1;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dpPre = new int[n];
        int[] dp = new int[n];
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                dpPre[j] = 0;
                break;
            }
            dpPre[j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            } else {
                dp[0] = dpPre[0];
            }
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j - 1] + dpPre[j];
                }
            }
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }

        return dpPre[n - 1];
    }
}
