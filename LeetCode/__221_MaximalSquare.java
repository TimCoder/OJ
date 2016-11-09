package tim.leetcode;

public class __221_MaximalSquare {

    /*
     * Time : O(M * N), Space : O(min(M, N)).
     * using time: 13 ms.
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        // dp[i][j] means the maximal square that must has (i, j).
        int[][] dp = new int[M + 1][N + 1];
        int max = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;

    }
                
    /*
     *1 0 1 0 0
     *1 0 1 1 1
     *1 1 1 1 1
     *1 0 0 1 0
     */
    /*
     * Time : O(M * N * min(M, N)), Space : O(M * N) -> O(min(M, N)).
     * using time : 11 ms.
     */
    /*
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        // dp[i][j] means the maximal square that must has (i, j).
        int[][] dp = new int[M + 1][N + 1];
        int max = 0;
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    int len = Math.min(i, j);
                    int cnt = 0; 
                    for (int k = 1; k <= len && dp[i - 1][j] >= k && dp[i][j - 1] >= k; ++k) {
                        ++cnt;
                    }
                    if (matrix[i - 1 - cnt][j - 1 - cnt] == '0') {
                        dp[i][j] = cnt;
                    } else {
                        dp[i][j] = cnt + 1;
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }

        return max * max;

    }
    */
}
