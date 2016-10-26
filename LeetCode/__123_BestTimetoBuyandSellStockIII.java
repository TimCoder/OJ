package tim.leetcode;

public class __123_BestTimetoBuyandSellStockIII {

    /*
     * time O(N^2)
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int N = prices.length;
        int profit1 = 0;
        int profit2 = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; ++i) {
            min1 = Math.min(prices[i], min1);
            profit1 = Math.max(prices[i] - min1, profit1);
            //only when profit1 > 0, calculate profit2.
            if (profit1 == 0) {
                continue;
            }
            for (int j = i + 1; j < N; ++j) {
                min2 = Math.min(prices[j], min2);
                profit2 = Math.max(prices[j] - min2, profit2);
                max = Math.max(profit1 + profit2, max);
            }
            max = Math.max(profit1 + profit2, max);
            profit1 = 0;
            profit2 = 0;
            min2 = Integer.MAX_VALUE;
        }

        return max;

    }

    /*
     * WA, must sell before buy, most twice.
     */
    /*
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int N = prices.length;
        int[] inc = new int[N-1];
        for (int i = 1; i < N; ++i) {
            inc[i - 1] = prices[i] - prices[i-1];
        }

        int sum = 0;
        int max = inc[0];
        int min = inc[0];
        int profit = 0; 
        for (int i = 0; i < N - 1; ++i) {
            min = Math.min(inc[i], min);
            sum += inc[i];
            if (sum < 0) {
                int tmpPft = max - min;
                profit = Math.max(tmpPft, profit);
                sum = 0;
                max = inc[i+1];
                min = inc[i+1];
            } else {
                max = Math.max(sum, max);
            }
        }

        return profit;

    }
    */

}
