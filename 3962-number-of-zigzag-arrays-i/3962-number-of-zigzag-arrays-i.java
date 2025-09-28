class Solution {
    final int mod = 1000000007;
    int solve(int n , int l , int r , int i , int t , int pv , int[][][] dp){
        if(i >= n)
            return 1;
        if(dp[i][t][pv] != -1)
            return dp[i][t][pv];
        int ans = 0;
        if(t == 1){
            for(int j = pv+1; j <= r; j++){
                ans = (ans+solve(n , l , r , i+1 , 0 , j , dp))%mod;
            }
        }else if(t == 0){
            for(int j = l; j < pv; j++){
                ans = (ans+solve(n , l , r , i+1 , 1 , j , dp))%mod;
            }
        }
        dp[i][t][pv] = ans;
        return dp[i][t][pv];
    }
    public int zigZagArrays(int n, int l, int r) {
        /*int[][][] dp1 = new int[n+1][2][r+2];
        int[][][] dp2 = new int[n+1][2][r+2];
        for(int[][] a : dp1){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        for(int[][] a : dp2){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return (solve(n , l , r , 0 , 0 , r+1 , dp1)+solve(n , l , r , 0 , 1 , l , dp2))%mod;*/
        int[][][] dp = new int[n+1][2][r+2];
        for(int i = 0; i < 2; i++){
            for(int j = l; j <= r; j++){
                dp[0][i][j] = 1;
            }
        }
        for(int i = 1; i < n; i++){
            int ps = 0;
            for(int j = l; j <= r; j++){
                dp[i][0][j] = ps;
                ps = (ps+dp[i-1][1][j])%mod; 
            }
            int ss = 0;
            for(int j = r; j >= l; j--){
                dp[i][1][j] = ss;
                ss = (ss+dp[i-1][0][j])%mod;
            }
        }
        int ans = 0;
        for(int i = 0; i < r+2; i++){
            ans = (ans+dp[n-1][0][i])%mod;
            ans = (ans+dp[n-1][1][i])%mod;
        }
        return ans;
    }
}