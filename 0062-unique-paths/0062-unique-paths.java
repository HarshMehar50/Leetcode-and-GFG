class Solution {
    int solve(int i , int j , int[][] dp){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = solve(i , j-1 , dp);
        int down = solve(i-1 , j , dp);
        int ans = right+down;
        dp[i][j] = ans;
        return ans;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(m-1 , n-1 , dp);
    }
}