package tim.leetcode;

public class __343_IntegerBreak {

    /*
     * Time : O(1), Space : O(N).
     * using time : 0 ms.
     * Math.pow(a, b) Time : O(1), http://blog.csdn.net/bobodem/article/details/49386085.
     */
    public int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        if (n % 3 == 0) {
            return (int)Math.pow(3, n / 3);
        }

        if (n % 3 == 1) {
            return 2 * 2 * (int)Math.pow(3, n / 3 - 1);
        }

        return 2 * (int)Math.pow(3, n / 3);
    }

    /*
     * Time : O(N ^ 2), Space : O(N).
     * using time : 1 ms.
     */
    /*
    public int integerBreak(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; ++i) {
            dp[i] = dp[i - 1];
            for (int j = 1; j <= i / 2; ++j) {
                dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
            }
        }

        return dp[n];

    }
    */
}
