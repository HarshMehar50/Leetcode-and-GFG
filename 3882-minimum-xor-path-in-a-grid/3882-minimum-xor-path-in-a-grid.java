class Solution {
    int solve(int[][] grid , int r , int c , int xor , int[][][] dp){
        if(r == grid.length-1 && c == grid[0].length-1)
        return xor;
        if(dp[r][c][xor] != -1)
        return dp[r][c][xor];
        int ans = Integer.MAX_VALUE;
        if(r+1 < grid.length && (grid[r+1][c]^xor) <= 1024)
        ans = Math.min(ans , solve(grid , r+1 , c , grid[r+1][c]^xor , dp));
        if(c+1 < grid[0].length && (grid[r][c+1]^xor) <= 1024)
        ans = Math.min(ans , solve(grid , r , c+1 , grid[r][c+1]^xor , dp));
        dp[r][c][xor] = ans;
        return dp[r][c][xor];
    }
    public int minCost(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][1025];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(grid , 0 , 0 , grid[0][0] , dp);
    }
}