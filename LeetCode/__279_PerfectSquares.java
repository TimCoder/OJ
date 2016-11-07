package tim.leetcode;

public class __279_PerfectSquares {

    /*
     * Time : O(N ^ log N), Space : O(N).
     * using time: 103 ms.
     */ 
    public int numSquares(int n) {

        if (n <= 0) { 
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];

    }
        

    /*
     * Time : O(N ^ 2), Space : O(N).
     * using time: 1084 ms.
     */ 
    /*
    public int numSquares(int n) {

        if (n <= 3) { 
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int cur = 2;
        int curSq = cur * cur;
        for (int i = 4; i <= n; ++i) {
            if (i == curSq) {
                dp[i] = 1; 
                ++cur;
                curSq = cur * cur;
            } else if (i < curSq) {
                int min = Integer.MAX_VALUE;
                for (int j = i - 1; j >= i / 2; --j) {
                    min = Math.min(dp[j] + dp[i - j], min);
                }
                dp[i] = min;
            }
        }

        return dp[n];
        
    }
    */

}

