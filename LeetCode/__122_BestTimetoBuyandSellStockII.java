package tim.leetcode;

public class __122_BestTimetoBuyanSellStockII {

    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        int N = prices.length;
        for (int i = 1; i < N; ++i) {
            int inc = prices[i] - prices[i-1];
            if (inc > 0) {
                profit += inc;
            }
        }

        return profit;

    }

}
