package tim.leetcode;

public class __322_CoinChange {
    /*
     * Time : O(M * N), Space : O(N)
     * using time :  629 ms.
     */
    public int coinChange(int[] coins, int amount) {

        int res = -1;
        int M = coins.length;
        int N = amount;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int j = 1; j < N + 1; ++j) {
            dp[j] = -1;
        }
        for (int i = 1; i < M + 1; ++i) {
            dp[0] = 0;
            for (int j = 0; j < N + 1; ++j) { 
                if (coins[i - 1] > j) {
                    continue;
                }
                int tmp = dp[j - coins[i - 1]];
                if (tmp == -1) {
                    continue;
                }
                if (dp[j] == -1) {
                    dp[j] = tmp + 1;
                } else {
                    dp[j] = Math.min(dp[j], tmp + 1);
                }
            }
            res = res == -1 ? dp[N] : Math.min(res, dp[N]); 
        }

        return res;

    }

    /*
     * Time : O(M * N * k), k = amount / coins[i], Space : O(N)
     * using time :  629 ms.
     */
    /*
    public int coinChange(int[] coins, int amount) {

        int res = -1;
        int M = coins.length;
        int N = amount;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int j = 1; j < N + 1; ++j) {
            dp[j] = -1;
        }
        for (int i = 1; i < M + 1; ++i) {
            dp[0] = 0;
            for (int j = N; j > 0; --j) { 
                for (int k = 1; k * coins[i - 1] <= j; ++k) {
                    int tmp = dp[j - k * coins[i - 1]];
                    if (tmp == -1) {
                        continue;
                    }
                    if (dp[j] == -1) {
                        dp[j] = tmp + k;
                    } else {
                        dp[j] = Math.min(dp[j], tmp + k);
                    }
                }
            }
            res = res == -1 ? dp[N] : Math.min(res, dp[N]); 
        }

        return res;

    }
    */


    /*
     * Time : O(M * N * k), k = amount / coins[i], Space : O(M * N)
     * using time : 716 ms.
     */
    /*
    public int coinChange(int[] coins, int amount) {

        int res = -1;
        int M = coins.length;
        int N = amount;
        int[][] dp = new int[M + 1][N + 1];
        dp[0][0] = 0;
        for (int j = 1; j < N + 1; ++j) {
            dp[0][j] = -1;
        }
        for (int i = 1; i < M + 1; ++i) {
            dp[1][0] = 0;
        }

        for (int i = 1; i < M + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                dp[i][j] = dp[i - 1][j] == - 1 ? -1 : dp[i - 1][j];
                for (int k = 1; k * coins[i - 1] <= j; ++k) {
                    int tmp = dp[i - 1][j - k * coins[i - 1]];
                    if (tmp == -1) {
                        continue;
                    }
                    if (dp[i][j] == -1) {
                        dp[i][j] = tmp + k;
                    } else {
                        dp[i][j] = Math.min(dp[i][j], tmp + k);
                    }
                }
            }
            res = res == -1 ? dp[i][N] : Math.min(res, dp[i][N]);
        }

        return res;

    }
    */

}
