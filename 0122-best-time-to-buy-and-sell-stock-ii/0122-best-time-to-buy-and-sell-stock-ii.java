class Solution {
    int solve(int[] prices , int index , int buy , int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buy] != -1)
        return dp[index][buy];
        int profit = 0;
        int buyskip = 0;
        int buyinclude = 0;
        int sellskip = 0;
        int sellinclude = 0;
        if(buy == 1){
            buyinclude = -prices[index]+solve(prices , index+1 , 0 , dp);
            buyskip = 0+solve(prices , index+1 , 1 , dp);
            profit = Math.max(buyinclude , buyskip);
        }else{
            sellinclude = prices[index]+solve(prices , index+1 , 1 , dp);
            sellskip = 0+solve(prices , index+1 , 0 , dp);
            profit = Math.max(sellinclude , sellskip);
        }
        dp[index][buy] = profit;
        return dp[index][buy];
    }
    int solveTab(int[] prices){
        int[][] dp = new int[prices.length+1][2];
        dp[prices.length-1][1] = 0;
        for(int i = prices.length-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                if(j == 1){
                    dp[i][j] = Math.max(dp[i+1][0]-prices[i] , dp[i+1][1]);
                }else{
                    dp[i][j] = Math.max(dp[i+1][1]+prices[i] , dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public int maxProfit(int[] prices) {
        /* int maxP = Integer.MIN_VALUE;
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(min < prices[i]){
                profit += prices[i]-min;
            }
            min = Math.min(min , prices[i]);
            maxP = Math.max(maxP , profit);

        }
        if(maxP < 0)
        return 0;
        else
        return maxP;*/
        int[][] dp =new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(prices , 0 , 1 , dp);
        //return solveTab(prices);
    }
}