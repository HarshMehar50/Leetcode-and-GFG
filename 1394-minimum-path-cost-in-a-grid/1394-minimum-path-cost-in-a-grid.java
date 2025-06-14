class Solution {
    int solve(int[][] grid , int[][] moveCost , int i , int j , int[][] dp){
        if(i == grid.length-1)
            return grid[i][j];
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < grid[0].length; k++){
            int val = moveCost[grid[i][j]][k];
            ans = Math.min(ans , grid[i][j]+val+solve(grid , moveCost , i+1 , k , dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < dp.length; j++){
                Arrays.fill(dp[j] , -1);
            }
            ans = Math.min(ans , solve(grid , moveCost , 0 , i , dp));
        }
        return ans;
    }
}