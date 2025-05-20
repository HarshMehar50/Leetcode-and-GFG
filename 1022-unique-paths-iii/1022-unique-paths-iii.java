class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    int solve(int[][] grid , int r , int c , int er , int ec , int c0){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1)
        return 0;
        if(r == er && c == ec){
            if(c0 == -1)
            return 1;
            else
            return 0;
        }
        int ans = 0;
        int t = grid[r][c];
        grid[r][c] = -1;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            ans += solve(grid , nr , nc , er , ec , c0-1);
        }
        grid[r][c] = t;
        return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        int sr = -1;
        int sc = -1;
        int er = -1;
        int ec = -1;
        int c0 = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
                if(grid[i][j] == 2){
                    er = i;
                    ec = j;
                }
                if(grid[i][j] == 0)
                c0++;
            }
        }
        return solve(grid , sr , sc , er , ec , c0);
    }
}