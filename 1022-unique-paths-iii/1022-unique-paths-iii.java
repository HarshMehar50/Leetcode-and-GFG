class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    int solve(int[][] grid , int r , int c , int c1){
        if(grid[r][c] == 2){
            if(c1 == -1)
            return 1;
            else
            return 0;
        }
        int t = grid[r][c];
        grid[r][c] = -1;
        int ans = 0;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] != -1)
            ans += solve(grid , nr , nc , c1-1);
        }
        grid[r][c] = t;
        return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        int sr = 0;
        int sc = 0;
        int c = 0;
        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] == 0)
                c++;
            }
        }
        return solve(grid , sr , sc , c);
    }
}