class Solution {
    public int maxProfit(int[] prices) {
        int maxP = Integer.MIN_VALUE;
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(min < prices[i]){
                profit = prices[i]-min;
            }
            min = Math.min(min , prices[i]);
            maxP = Math.max(maxP , profit);
        }
        if(maxP < 0)
        return 0;
        else
        return maxP;
    }
}