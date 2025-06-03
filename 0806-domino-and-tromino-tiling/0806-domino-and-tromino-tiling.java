class Solution {
    final int mod = 1000000007;
    int solveTab(int n){
        if(n == 1 || n == 2)
            return n;
        if(n == 3)
            return 5;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++){
            dp[i] = ((2*dp[i-1])%mod + dp[i-3]%mod)%mod;
        }
        return dp[n];
    }
    int solve(int n , int[] dp){
        if(n == 1 || n == 2)
            return n;
        if(n == 3)
            return 5;
        if(dp[n] != -1)
            return dp[n];
        int ans = ((2*solve(n-1 , dp))%mod+solve(n-3 , dp)%mod)%mod;
        dp[n] = ans;
        return dp[n];
    }
    public int numTilings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp)%mod;
        //return solveTab(n);
    }
}