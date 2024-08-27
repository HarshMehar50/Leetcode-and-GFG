class Solution {
    int solve(int[][] grid , int i , int j , int[][] dp){
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        else if(i == 0 && j == 0){
            return grid[i][j];
        }else if(dp[i][j] != 0){
            return dp[i][j];
        }
        int right = solve(grid , i , j-1 , dp);
        int down = solve(grid , i-1 , j , dp);
        int ans = grid[i][j] + Math.min(right , down);
        dp[i][j] = ans;
        return dp[i][j];
    }
   /* int solveTab(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];
        for(int i = grid.length-1; i >= 1; i--){
            for(int j = grid[0].length-1; j >= 1; j--){
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[0][0];
    }*/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return solve(grid , grid.length-1 , grid[0].length-1 , dp);
        //return solveTab(grid);
    }
}