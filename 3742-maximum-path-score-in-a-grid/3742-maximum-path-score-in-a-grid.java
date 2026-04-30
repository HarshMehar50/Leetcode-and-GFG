class Solution {
    int solve(int[][] grid , int k , int r , int c , int[][][] dp){
        if(r >= grid.length || c >= grid[0].length)
        return Integer.MIN_VALUE;
        int nc = Math.min(grid[r][c] , 1);
        if(k-nc < 0)
        return Integer.MIN_VALUE;
        if(r == grid.length-1 && c == grid[0].length-1)
        return grid[r][c];
        if(dp[r][c][k] != -1)
        return dp[r][c][k];
        int ans = grid[r][c]+Math.max(solve(grid , k-nc , r+1 , c , dp) , solve(grid , k-nc , r , c+1 , dp));
        dp[r][c][k] = ans;
        return dp[r][c][k];
    }
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        int ans = solve(grid , k , 0 , 0 , dp);
        if(ans < 0)
        return -1;
        return ans;
    }
}