class Solution {
    long solve(int n , int[][] cost , int i , int l , int r , long[][][] dp){
        if(i >= n/2)
        return 0;
        if(dp[i][l][r] != -1)
        return dp[i][l][r];
        long ans = Long.MAX_VALUE;
        for(int j = 0; j < 3; j++){
            if(j != l){
                for(int k = 0; k < 3; k++){
                    if(k != r && j != k)
                    ans = Math.min(ans , cost[i][j]+cost[n-1-i][k]+solve(n , cost , i+1 , j , k , dp));
                }
            }
        }
        dp[i][l][r] = ans;
        return dp[i][l][r];
    }
    public long minCost(int n, int[][] cost) {
        long[][][] dp = new long[n+1][4][4];
        for(long[][] a : dp){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(n , cost , 0 , 3 , 3 , dp);
    }
}