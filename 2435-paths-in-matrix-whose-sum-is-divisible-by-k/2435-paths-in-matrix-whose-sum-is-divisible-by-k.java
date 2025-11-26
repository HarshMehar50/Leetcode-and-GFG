class Solution {
    final int mod = 1000000007;
    int solve(int[][] grid , int k , int r , int c , int rem , int[][][] dp){
        if(r == grid.length-1 && c == grid[0].length-1){
            if(rem%k == 0)
            return 1;
            else
            return 0;
        }
        if(dp[r][c][rem] != -1)
        return dp[r][c][rem];
        int down = 0;
        if(r+1 < grid.length)
        down = solve(grid , k , r+1 , c , (rem+grid[r+1][c])%k , dp)%mod;
        int right = 0;
        if(c+1 < grid[0].length)
        right = solve(grid , k , r , c+1 , (rem+grid[r][c+1])%k , dp)%mod;
        int ans = (right+down)%mod;
        dp[r][c][rem] = ans;
        return dp[r][c][rem];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(grid , k , 0 , 0 , grid[0][0]%k , dp);
    }
}