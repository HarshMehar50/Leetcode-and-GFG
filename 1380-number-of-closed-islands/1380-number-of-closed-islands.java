class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    boolean DFS(int[][] grid , boolean[][] visited , int r , int c){
        visited[r][c] = true;
        boolean ans = true;
        if (r == 0 || c == 0 || r == grid.length - 1 || c == grid[0].length - 1)
        ans = false;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == 0)
            if(!DFS(grid , visited , nr , nc))
            ans = false;
        }
        return ans;
    }
    public int closedIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 0){
                    if(DFS(grid , visited , i , j))
                    ans++;
                }
            }
        }
        return ans;
    }
}