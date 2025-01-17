class Solution {
    int solve(int[][] grid , int i , int j , int[][] dp){
        if(i == grid.length-1)
        return grid[i][j];
        if(i >= grid.length || j >= grid[0].length)
        return Integer.MAX_VALUE;
        if(dp[i][j] != Integer.MAX_VALUE)
        return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < grid[0].length; k++){
            if(k == j) continue;
            ans = Math.min(ans , solve(grid , i+1 , k , dp)+grid[i][j]);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    /*int solve(int[][] grid , int r , int c){
        if(r >= grid.length)
        return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++){
            if(i == c) continue;
            ans = Math.min(ans , solve(grid , r+1 , i)+grid[r][c]);
        }
        return ans;
    }*/
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
        }
        for(int i = 0; i < grid[0].length; i++){
        ans = Math.min(ans , solve(grid , 0 , i , dp));
        }
        return ans;
    }
}