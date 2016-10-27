package tim.leetcode;

public class __309_BestTimetoBuyandSellStockwithCooldown {

    /*
     * https://discuss.leetcode.com/topic/30421/share-my-thinking-process
     * state : buy[i], sell[i], rest[i]. 
    */

    public int maxProfit(int[] prices) {

        int buy = Integer.MIN_VALUE, preBuy;
        int sell = 0, preSell = 0;
        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preSell - price, preBuy);// can't buy if yesterday just sell.
            preSell = sell;
            sell = Math.max(preBuy + price, preSell);//can't sell if last transaction was not buy.
        }   

        return sell;

    }
    
    /*
    public int maxProfit(int[] prices) {

        // int N = prices.length;
        // if (prices == null || N < 2) {
        //     return 0;
        // }   

        int preBuy = Integer.MIN_VALUE, buy;
        int preSell = 0, sell = 0;
        int preRest = 0, rest;
        for (int price : prices) {
            buy = Math.max(preRest - price, preBuy);// can't buy if yesterday just sell.
            sell = Math.max(preBuy + price, preSell);//can't sell if last transaction was not buy.
            //rest = Math.max(Math.max(preBuy, preSell),preRest);
            rest = preSell;
            
            preBuy = buy;
            preSell = sell;
            preRest = rest;
            
        }   

        return sell;

    }
    */
    
    /*
    public int maxProfit(int[] prices) {

        int N = prices.length;
        if (prices == null || N < 2) {
            return 0;
        }

        int[] result = new int[N];
        result[0] = 0;
        int profit = prices[1] - prices[0];
        result[1] = Math.max(profit, 0);
        boolean isCoolDown = false;
        int i = 2;
        while (i < N) {

            //今天收益
            profit = prices[i] - prices[i-1];
            if (!isCoolDown) {
            //昨天未卖
                if (profit >= 0) {
                //今天不卖  
                    result[i] = profit + result[i-1];
                } else {
                //今天卖
                    result[i] = result[i-1];
                    isCoolDown = !isCoolDown;
                }
            } else {
            //昨天刚卖
                result[i] = result[i-1];
                isCoolDown = !isCoolDown;
            }
            ++i;

        }

        return result[N-1];

    }
    */
}
