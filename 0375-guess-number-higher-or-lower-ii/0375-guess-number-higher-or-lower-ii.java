class Solution {
    int solve(int start , int end , int[][] dp){
        if(start >= end){
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            ans = Math.min(ans , i+Math.max(solve(start , i-1 , dp) , solve(i+1 , end , dp)));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }
    int solveTab(int n){
        int[][] dp = new int[n+1][n+1];
        for(int start = n-1; start >= 1; start--){
            for(int end = 1; end <= n; end++){
                if(start == end){
                    dp[start][end] = 0;
                }else{
                    int ans = Integer.MAX_VALUE;
                    for(int i = start; i <= end; i++){
                        ans = Math.min(ans , i+Math.max(dp[start][i-1] , dp[i+1][end]));
                    }
                    dp[start][end] = ans;
                }
            }
        }
        return dp[1][n];
    }
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = -1;
            }
        }
        return solve(1 , n , dp);
        //return solveTab(n);
    }
}