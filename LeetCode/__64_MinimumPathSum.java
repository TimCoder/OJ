package tim.leetcode;

public class  __64_MinimumPathSum {

    /*
     * time : O(M * N), space : O(N). O(min(N,M))) 
     */
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        int[] cur = new int[N];
        cur[0] = grid[0][0];
        for (int i = 1; i < N; ++i) {
            cur[i] = grid[0][i] + cur[i - 1];
        }

        for (int i = 1; i < M; ++i) {
            cur[0] = grid[i][0] + cur[0];
            for (int j = 1; j < N; ++j) {
                cur[j] = grid[i][j] + Math.min(cur[j], cur[j - 1]);
            }
        }

        return cur[N - 1];

    }

    /*
     * time : O(M * N), space : O(2 * N). O(2 * min(N,M))) 
     */
    /*
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        //pre line
        int[] pre = new int[N];
        int[] cur = new int[N];
        int[] tmp;

        pre[0] = grid[0][0];
        for (int i = 1; i < N; ++i) {
            pre[i] = grid[0][i] + pre[i - 1];
        }

        for (int i = 1; i < M; ++i) {
            cur[0] = grid[i][0] + pre[0];
            for (int j = 1; j < N; ++j) {
                cur[j] = grid[i][j] + Math.min(pre[j], cur[j - 1]);
            }
            tmp = cur;
            cur = pre;
            pre = tmp;
        }

        return pre[N - 1];

    }
    */

    /*
     * time : O(M * N), space : O(M * N)
     */
    /*
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < N; ++j) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < M; ++i) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < M; ++i) {
            for (int j = 1; j < N; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[M - 1][N - 1];

    }
    */

}
