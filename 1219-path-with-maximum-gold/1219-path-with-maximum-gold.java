class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    int solve(int[][] grid , int r , int c){
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == 0 )
        return 0;
        
        int t = grid[r][c];
        grid[r][c] = 0;
        int ans = t;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] != 0){
                
                ans = Math.max(ans , t+solve(grid , nr , nc));
            }
        }
        grid[r][c] = t;
        return ans;
    }
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0)
                ans = Math.max(ans , solve(grid , i , j));
            }
        }
        return ans;
    }
}