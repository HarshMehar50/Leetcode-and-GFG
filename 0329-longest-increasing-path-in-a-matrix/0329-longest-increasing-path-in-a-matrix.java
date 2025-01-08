class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    int solve(int[][] matrix , int i , int j , int[][] dp){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        int ans = 0;
        for(int k = 0; k < 4; k++){
            int nr = i+dR[k];
            int nc = j+dC[k];
            if(nr < matrix.length && nr >= 0 && nc < matrix[0].length && nc >= 0 && matrix[nr][nc] > matrix[i][j])
            ans = Math.max(ans , 1+solve(matrix , nr , nc , dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(dp[i][j] != -1)
                ans = Math.max(ans , 1+dp[i][j]);
                else
                ans = Math.max(ans , 1+solve(matrix , i , j , dp));
            }
        }
        return ans;
    }
}