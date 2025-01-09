class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    void DFS(int r , int c , int[][] grid , boolean[][] visited){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1 && !visited[nr][nc])
            DFS(nr , nc , grid , visited);
        }
    }
    int components(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    c++;
                    DFS(i , j , grid , visited);
                }
            }
        }
        return c;
    }
    public int minDays(int[][] grid) {
        int icomp = components(grid);
        if(icomp > 1)
        return 0;
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                l.add(new int[]{i , j});
            }
        }
        for(int i = 0; i < l.size(); i++){
            grid[l.get(i)[0]][l.get(i)[1]] = 0;
            int comp = components(grid);
            if(comp > 1)
            return 1;
            grid[l.get(i)[0]][l.get(i)[1]] = 1;
        }
        return 2;
    }
}