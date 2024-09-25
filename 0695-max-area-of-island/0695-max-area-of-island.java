class Solution {
    int DFS(int r , int c , boolean[][] visited , int[][] grid , int[] dR , int[] dC){
        int count = 1;
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                if(!visited[nr][nc] && grid[nr][nc] == 1)
                count += DFS(nr , nc , visited , grid , dR , dC);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , -1 , 0 , 1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans = Math.max(ans , DFS(i , j , visited , grid , dR , dC));
                }
            }
        }
        return ans;
    }
}