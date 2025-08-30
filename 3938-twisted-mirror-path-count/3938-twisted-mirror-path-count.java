class Solution {
    final int mod = 1000000007;
    int[] dR = {1 , 0};
    int[] dC = {0 , 1};
    int solve(int[][] grid , int r , int c , int pm , int[][][] dp){
        if(r >= grid.length || c >= grid[0].length)
            return 0;
        if(r == grid.length-1 && c == grid[0].length-1)
            return 1;
        /*int ans = 0;
        for(int i = 0; i < 2; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nc < grid[0].length){
                if(grid[nr][nc] == 0)
                    ans = (ans+solve(grid , nr , nc , dp))%mod;
                else{
                    if(i == 0)
                    nc++;
                    else
                    nr++;
                    ans = (ans+solve(grid , nr , nc , dp))%mod;
                }
            }
        }
        dp[r][c] = ans;
        return dp[r][c];*/
        if(dp[r][c][pm+1] != -1)
        return dp[r][c][pm+1];
        int ans = 0;
        if(grid[r][c] == 1){
            if(pm == 0){
                /*while(c < grid[0].length && grid[r][c] == 1){
                    c++;
                }*/
                return solve(grid , r , c+1 , 1 , dp);
            }else if(pm == 1){
                /*while(r < grid.length && grid[r][c] == 1){
                    r++;
                }*/
                return solve(grid , r+1 , c , 0 , dp);
            }
            if(r == grid.length-1 && c == grid[0].length-1)
            return 1;
        }
        int right = solve(grid , r , c+1 , 1 , dp);
        int down = solve(grid , r+1 , c , 0 , dp);
        ans = (right+down)%mod;
        dp[r][c][pm+1] = ans;
        return dp[r][c][pm+1];
    }
    public int uniquePaths(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][3];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(grid , 0 , 0 , -1 , dp);
    }
}