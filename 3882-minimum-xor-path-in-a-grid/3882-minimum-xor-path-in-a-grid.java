class Solution {
    int solve(int[][] grid , int r , int c , int xor){
        if(r == grid.length-1 && c == grid[0].length-1)
        return xor;
        int ans = Integer.MAX_VALUE;
        if(r+1 < grid.length)
        ans = Math.min(ans , solve(grid , r+1 , c , grid[r+1][c]^xor));
        if(c+1 < grid[0].length)
        ans = Math.min(ans , solve(grid , r , c+1 , grid[r][c+1]^xor));
        return ans;
    }
    public int minCost(int[][] grid) {
        return solve(grid , 0 , 0 , grid[0][0]);
    }
}