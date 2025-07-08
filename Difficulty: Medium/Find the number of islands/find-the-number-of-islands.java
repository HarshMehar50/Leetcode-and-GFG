class Solution {
    int[] dR = {1 , 0 , -1 , 0 , 1 , -1 , 1 , -1};
    int[] dC = {0 , 1 , 0 , -1 , 1 , -1 , -1 , 1};
    void DFS(char[][] grid , boolean[][] visited , int r , int c){
        visited[r][c] = true;
        for(int i = 0; i < 8; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == 'L')
            DFS(grid , visited , nr , nc);
        }
    }
    public int countIslands(char[][] grid) {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 'L'){
                    ans++;
                    DFS(grid , visited , i , j);
                }
            }
        }
        return ans;
    }
}