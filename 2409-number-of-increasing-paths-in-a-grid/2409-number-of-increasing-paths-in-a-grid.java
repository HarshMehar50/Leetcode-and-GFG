class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    final int mod = 1000000007;
    int solve(int[][] grid , int i , int j , int[][] dp){
        if(i >= grid.length || j >= grid[0].length || j < 0 || i < 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        for(int k = 0; k < 4; k++){
            int nr = i+dR[k];
            int nc = j+dC[k];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] > grid[i][j])
                ans = (ans+1+solve(grid , nr , nc , dp))%mod;
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int countPaths(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                ans = (ans+1)%mod;
                if(dp[i][j] != -1)
                    ans = (ans+dp[i][j])%mod;
                else
                    ans = (ans+solve(grid , i , j , dp))%mod;
            }
        }
        return ans;
    }
}