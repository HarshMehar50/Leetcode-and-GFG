class Solution {
    final int mod = 1000000007;
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    int solve(int n , int p1 , int p2 , int[][][] dp){
        if(n == 0)
        return 1;
        if(dp[n][p1][p2] != -1)
        return dp[n][p1][p2];
        int ans = 0;
        if(p1 == 0){
            for(int i = 1; i <= 6; i++){
                ans = (ans+solve(n-1 , i , 0 , dp))%mod;
            }
        }else{
            for(int i = 1; i <= 6; i++){
                if(gcd(i , p1) == 1 && i != p2 && i != p1)
                ans = (ans+solve(n-1 , i , p1 , dp))%mod;
            }
        }
        dp[n][p1][p2] = ans%mod;
        return dp[n][p1][p2];
    }
    public int distinctSequences(int n) {
        int[][][] dp = new int[n+1][7][7];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(n , 0 , 0 , dp);
    }
}