class Solution {
    public int maxProfit(int[] prices) {
        
        // Lets consider the leftmost element as the minimum value where we buy
        int minValue = prices[0];
        int maxProfit = 0;

        for (int i=1; i < prices.length; i++) {
            // if we find a value which is less than the minimum value, we will update the minimum value
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                // if we find a value which is greater than the minimum value, we will calculate the profit and update the maximum profit value
                int profit = prices[i] - minValue;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
