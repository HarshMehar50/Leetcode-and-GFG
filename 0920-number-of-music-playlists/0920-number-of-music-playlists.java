class Solution {
    final int mod = 1000000007;
    long solve(int n , int goal , int k , int cs , int cus , long[][] dp){
        if(cs == goal){
            if(cus == n)
            return 1;
            else
            return 0;
        }
        if(dp[cs][cus] != -1)
        return dp[cs][cus];
        long ans = 0;
        if(cus < n)
        ans = (ans+((long)(n-cus)*solve(n , goal , k , cs+1 , cus+1 , dp))%mod)%mod;
        if(cus > k)
        ans = (ans+((long)(cus-k)*solve(n , goal , k , cs+1 , cus , dp))%mod)%mod;
        dp[cs][cus] = ans;
        return dp[cs][cus];
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        for(long[] a : dp){
            Arrays.fill(a , -1);
        }
        return (int)solve(n , goal , k , 0 , 0 , dp);
    }
}