class Solution {
    int solve(int n, int k, int target , int[][] dp){
        if(n != 0 && target == 0){
            return 0;
        }
        if(target < 0){
            return 0;
        }
        if(n == 0 && target != 0){
            return 0;
        }
        if(n == 0 && target == 0){
            return 1;
        }
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int ans = 0;
        for(int i = 1; i <= k; i++){
            ans = (ans + solve(n-1 , k , target-i , dp))%((int)Math.pow(10 , 9)+7);
        }
        dp[n][target] = ans;
        return dp[n][target];
    }
    int solveTab(int n, int k, int target){
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int x = 1; x <= k; x++){
                    if(j-x >= 0)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-x])%((int)Math.pow(10 , 9)+7);
                }
            }
        }
        return dp[n][target];
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < target+1; j++){
                dp[i][j] = -1;
            }
        }
        return solve(n , k , target , dp);
        //return solveTab(n , k , target);
    }
}