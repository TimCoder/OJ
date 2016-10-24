package tim.leetcode;

public class __121_BestTimetoBuyandSellStock {

    /*
     * time O(1*N)
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int N = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; ++i) {
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }

        return max;

    }
    
    /*
     * time O(2N) 
    */ 
    /*
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
     
        int max = 0;
        int N = prices.length;
        int[] inc = new int[N-1];
        for (int i = 0; i < N - 1; ++i) {
            inc[i] = prices[i+1] - prices[i];
        }   

        int sum = 0;
        for(int i = 0; i < N - 1; ++i) {
            sum += inc[i];
            if (sum < 0) {
                sum = 0;
            } else {
                if (sum > max) {
                    max = sum; 
                }   
            }   
        }   
                
        return max;

    }
    */

    /* TLE, time O(N^2)
    public int maxProfit(int[] prices) {

        int result = 0;
        int n = prices.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int profit = prices[j] - prices[i];
                if (profit > result) {
                    result = profit;
                }   
            }   
        }   
            
        return result;
         
    }
    */

}
