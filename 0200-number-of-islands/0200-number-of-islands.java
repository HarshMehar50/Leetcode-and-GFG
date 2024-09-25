class Solution {
    void DFS(int r , int c , boolean[][] visited , char[][] grid , int[] dR , int[] dC){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                if(!visited[nr][nc] && grid[nr][nc] == '1')
                DFS(nr , nc , visited , grid , dR , dC);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int c = 0;
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    c++;
                    DFS(i , j , visited , grid , dR , dC);
                }
            }
        }
        return c;
    }
}