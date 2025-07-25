class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    void DFS(int[][] grid , boolean[][] visited , int r , int c , int[] a){
        visited[r][c] = true;
        a[0] += grid[r][c];
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == 1)
            DFS(grid , visited , nr , nc , a);
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int[] a = {0};
                    DFS(grid , visited , i , j , a);
                    ans = Math.max(ans , a[0]);
                }
            }
        }
        return ans;
    }
}