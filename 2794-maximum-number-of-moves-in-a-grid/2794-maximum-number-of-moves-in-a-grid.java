class Solution {
    int solve(int[][] grid , int r , int c , int[][] dp){
        if(c >= grid[0].length || r >= grid.length)
            return 0;
        if(dp[r][c] != -1)
            return dp[r][c];
        int[][] d = {{-1 , 1} , {0 , 1} , {1 , 1}};
        int ans = 0;
        for(int i = 0; i < 3; i++){
            int nr = r+d[i][0];
            int nc = c+d[i][1];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length)
                if(grid[nr][nc] > grid[r][c])
                    ans = Math.max(ans , 1+solve(grid , nr , nc , dp));
        }
        dp[r][c] = ans;
        return dp[r][c];
    }
    public int maxMoves(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        for(int i = 0; i < grid.length; i++){
            ans = Math.max(ans , solve(grid , i , 0 , dp));
        }
        return ans;
    }
}