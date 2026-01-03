class Solution {
    final int mod = 1000000007;
    int solve(int n , int p0 , int p1 , int p2 , int[][][][] dp){
        if(n == 0)
        return 1;
        if(dp[n][p0+1][p1+1][p2+1] != -1)
        return dp[n][p0+1][p1+1][p2+1];
        int ans  = 0;
        for(int i = 0; i < 3; i++){
            if(i != p0){
                for(int j = 0; j < 3; j++){
                    if(j != i && j != p1){
                        for(int k = 0; k < 3; k++){
                            if(k != j && k != p2)
                            ans = (ans+solve(n-1 , i , j , k , dp))%mod;
                        }
                    }
                }
            }
        }
        dp[n][p0+1][p1+1][p2+1] = ans%mod;
        return dp[n][p0+1][p1+1][p2+1];
    }
    public int numOfWays(int n) {
        int[][][][] dp = new int[n+1][4][4][4];
        for(int[][][] a : dp){
            for(int[][] b : a){
                for(int[] c : b){
                    Arrays.fill(c , -1);
                }
            }
        }
        return solve(n , -1 , -1 , -1 , dp);
    }
}