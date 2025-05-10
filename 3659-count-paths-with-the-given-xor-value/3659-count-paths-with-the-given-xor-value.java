class Solution {
    final int mod = 1000000007;
    int solve(int[][] grid , int k , int r , int c , int cxor , int[][][] dp){
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0)
        return 0;
        cxor ^= grid[r][c];
        if(r == grid.length-1 && c == grid[0].length-1){
            if(cxor == k)
            return 1;
            else
            return 0;
        }
        if(dp[r][c][cxor] != -1)
        return dp[r][c][cxor];
        int right = solve(grid , k , r , c+1 , cxor , dp)%mod;
        int down = solve(grid , k , r+1 , c , cxor , dp)%mod;
        int ans = (right+down)%mod;
        dp[r][c][cxor] = ans;
        return dp[r][c][cxor];
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][30];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        return solve(grid , k , 0 , 0 , 0 , dp);
    }
}