class Solution {
    long solve(int[] prices , int k , int i , int t , boolean c , long[][][] dp){
        if(i >= prices.length){
            if(t != 0)
            return Integer.MIN_VALUE;
            return 0;
        }
        if(k == 0)
        return 0;
        if(dp[i][k][t] != -1)
        return dp[i][k][t];
        long ans = Integer.MIN_VALUE;
        long buy1 = Integer.MIN_VALUE;
        long sell1 = Integer.MIN_VALUE;
        long buy2 = Integer.MIN_VALUE;
        long sell2 = Integer.MIN_VALUE;
        long exclude = Integer.MIN_VALUE;
        if(c){
            exclude = solve(prices , k , i+1 , 0 , true , dp);
            buy1 = solve(prices , k , i+1 , 1 , false , dp)-prices[i];
            sell2 = solve(prices , k , i+1 , 2 , false , dp)+prices[i];
            ans = Math.max(ans , Math.max(exclude , Math.max(buy1 , sell2)));
        }else{
            if(t == 1){
                sell1 = solve(prices , k-1 , i+1 , 0 , true , dp)+prices[i];
                exclude = solve(prices , k , i+1 , t , false , dp);
                ans = Math.max(ans , Math.max(exclude , sell1));
            }else if(t == 2){
                buy2 = solve(prices , k-1 , i+1 , 0 , true , dp)-prices[i];
                exclude = solve(prices , k , i+1 , t , false , dp);
                ans = Math.max(ans , Math.max(exclude , buy2));
            }
        }
        dp[i][k][t] = ans;
        return dp[i][k][t];
    }
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length][k+1][3];
        for(long[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        } 
        return solve(prices , k , 0 , 0 , true , dp);
    }
}