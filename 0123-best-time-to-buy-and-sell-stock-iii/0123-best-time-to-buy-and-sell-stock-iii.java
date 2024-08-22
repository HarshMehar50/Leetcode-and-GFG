class Solution {
    int solveTab(int k, int[] prices){
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i = prices.length-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                for(int l = 1; l <= k; l++){
                    if(j == 1){
                        dp[i][j][l] = Math.max(-prices[i]+dp[i+1][0][l] , dp[i+1][1][l]);
                    }else{
                        dp[i][j][l] = Math.max(prices[i]+dp[i+1][1][l-1] , dp[i+1][0][l]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
    public int maxProfit(int[] prices) {
        return solveTab(2 , prices);
    }
}