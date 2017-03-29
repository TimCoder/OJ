package tim.DP;

public class MinPathSum_O_N_Space {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        int[] dpPre = new int[n];
        dpPre[0] = grid[0][0];
        for (int i = 1; i < n; ++i) {
            dpPre[i] = dpPre[i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; ++i) {
            dp[0] = dpPre[0] + grid[i][0]; 
            for (int j = 1; j < n; ++j) {
                dp[j] = Math.min(dpPre[j], dp[j - 1]) + grid[i][j];
            }
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }

        return dpPre[n - 1];
    }
}
