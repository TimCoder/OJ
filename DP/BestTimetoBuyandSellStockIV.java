package tim.DP;

public class BestTimetoBuyandSellStockIV {
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj])      { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj])) { jj in range of [0, j-1] }
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        if (k >= prices.length) return maxProfitHelper(prices);
        
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; ++i) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; ++j) {
                dp[i][j] = Math.max(prices[j] + localMax, dp[i][j - 1]);
                localMax = Math.max(dp[i - 1][j] - prices[j], localMax);
            }
        }
        
        return dp[k][prices.length - 1];
    }
    
    public int maxProfitHelper(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
