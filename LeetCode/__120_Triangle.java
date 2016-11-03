package tim.leetcode;

import java.util.List;

public class __120_Triangle {

    /*
     * Time: O(N ^ 2), Space: O(N).
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int N = triangle.size();
        int[] dpPre = new int[N];
        int[] dp = new int[N];
        dpPre[0] = triangle.get(0).get(0);
        int res = dpPre[0];
        for (int i = 1; i < N; ++i) {
            List<Integer> list = triangle.get(i);
            res = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); ++j) {
                if (j == 0) {
                    dp[j] = list.get(j) + dpPre[j];
                } else if (j == list.size() - 1) {
                    dp[j] = list.get(j) + dpPre[j - 1];
                } else {
                    dp[j] = list.get(j) + Math.min(dpPre[j - 1], dpPre[j]);
                }
                res = Math.min(dp[j], res);
            }
            int[] tmp = dp;
            dp = dpPre;
            dpPre = tmp;
        }

        return res;

    }

    /*
     * Time: O(N ^ 2), Space: O(N ^ 2).
     */
    /*
    public int minimumTotal(List<List<Integer>> triangle) {

        int N = triangle.size();
        int[][] dp = new int[N][N];
        dp[0][0] = triangle.get(0).get(0);
        int[] res = new int[N];
        res[0] = dp[0][0];
        for (int i = 1; i < N; ++i) {
            List<Integer> list = triangle.get(i);
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); ++j) {
                if (j == 0) {
                    dp[i][j] = list.get(j) + dp[i - 1][j];
                } else if (j == list.size() - 1){
                    dp[i][j] = list.get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = list.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                res[i] = Math.min(dp[i][j], res[i]);
            }
        }

        return res[N - 1];

    }
    */

}
