package tim.DP;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < n; ++i) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; ++i) {
            res[i][0] = res[i - 1][0] + grid[i][0]; 
            for (int j = 1; j < n; ++j) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }

        return res[m - 1][n - 1];
    }
}
