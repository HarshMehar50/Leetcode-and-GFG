class Solution {
    final int mod = 1000000007;
    int solve(int n , int minProfit , int[] group , int[] profit , int i , int p , int t , int[][][] dp){
        if(t > n)
            return 0;
        if(i >= group.length){
            if(p >= minProfit)
                return 1;
            else
                return 0;
        }
        if(dp[i][p][t] != -1)
            return dp[i][p][t];
        int include = solve(n , minProfit , group , profit , i+1 , Math.min(p+profit[i] , minProfit) , t+group[i] , dp)%mod;
        int exclude = solve(n , minProfit , group , profit , i+1 , p , t , dp)%mod;
        int ans = ((include%mod)+(exclude%mod))%mod;
        dp[i][p][t] = ans;
        return dp[i][p][t];
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length][minProfit+1][n+1];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        return solve(n , minProfit , group , profit , 0 , 0 , 0 , dp);
    }
}