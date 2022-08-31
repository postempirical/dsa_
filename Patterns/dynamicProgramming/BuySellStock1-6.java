// BUY SELL STOCK 1
class Solution {
    public int maxProfit(int[] prices) {
        // keep a track of minimum price
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - minPrice; // selling
            profit = Math.max(profit, cost); // storing max sell
            minPrice = Math.min(minPrice, prices[i]); // updating min buy
        }
        return profit;
    }
}


// BUY SELL STOCK 2
