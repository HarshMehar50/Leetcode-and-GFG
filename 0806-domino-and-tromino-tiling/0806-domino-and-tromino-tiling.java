class Solution {
    final int mod = 1000000007;
    int solve(int n , int[] dp){
        if(n == 1 || n == 2)
        return n;
        if(n == 3)
        return 5;
        if(dp[n] != -1)
        return dp[n];
        dp[n] = ((2*solve(n-1 , dp))%mod+solve(n-3 , dp)%mod)%mod;
        return dp[n];
    }
    public int numTilings(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp)%mod;
    }
}