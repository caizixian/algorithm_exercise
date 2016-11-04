public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int current_min = prices[0];
        int[] min = new int[prices.length]; // minimum before prices[i]
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < current_min) {
                current_min = prices[i];
            }
            min[i + 1] = current_min;
        }
        int max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min[i] > max_profit) {
                max_profit = prices[i] - min[i];
            }
        }
        return max_profit;
    }
}