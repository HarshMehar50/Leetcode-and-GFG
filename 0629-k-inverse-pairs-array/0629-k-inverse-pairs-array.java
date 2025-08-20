class Solution {
    final int mod = 1000000007;
    int solveTab(int n , int k){
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                for(int inversion = 0; inversion <= Math.min(j , i-1); inversion++){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-inversion])%mod;
                }
            }
        }
        return dp[n][k];
    }
    int solve(int n , int k , int[][] dp){
        if(n == 0)
        return 0;
        if(k == 0)
        return 1;
        if(dp[n][k] != -1)
        return dp[n][k];
        int ans = 0;
        for(int inversion = 0; inversion <= Math.min(k , n-1); inversion++){
            ans = (ans+solve(n-1 , k-inversion , dp))%mod;
        }
        dp[n][k] = ans;
        return dp[n][k];
    }
    public int kInversePairs(int n, int k) {
        /*int[][] dp = new int[n+1][k+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(n , k , dp);*/
        return solveTab(n , k);
    }
}