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
    void DFSAP(int r , int c , int pr , int pc , int timer , int[][] discovery , int[][] low , List<int[]> ans , boolean[][] visited , int[][] grid){
        visited[r][c] = true;
        discovery[r][c] = low[r][c] = timer;
        timer++;
        int child = 0;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1){
            if(nr == pr && nc == pc) continue;
            if(!visited[nr][nc]){
                DFSAP(nr , nc , r , c , timer , discovery , low , ans , visited , grid);
                low[r][c] = Math.min(low[r][c] , low[nr][nc]);
                if(low[nr][nc] >= discovery[r][c] && pr != -1 && pc != -1)
                ans.add(new int[]{r , c});
                child++;
            }else
            low[r][c] = Math.min(low[r][c] , discovery[nr][nc]);
            }
        }
        if(pr == -1 && pc == -1 && child > 1)
        ans.add(new int[]{r , c});
    }
    int articulationPoints(int[][] grid){
        int[][] discovery = new int[grid.length][grid[0].length];
        int[][] low = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(discovery[i] , -1);
            Arrays.fill(low[i] , -1);
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int timer = 0;
        int pr = -1;
        int pc = -1;
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1)
                DFSAP(i , j , pr , pc , timer , discovery , low , ans , visited , grid);
            }
        }
        return ans.size();
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
        if(l.size() <= 2)
        return l.size();
        // BRUTE FORCE
        /*for(int i = 0; i < l.size(); i++){
            grid[l.get(i)[0]][l.get(i)[1]] = 0;
            int comp = components(grid);
            if(comp > 1)
            return 1;
            grid[l.get(i)[0]][l.get(i)[1]] = 1;
        }
        return 2;*/
        int ans = articulationPoints(grid);
        if(ans == 0)
        return 2;
        else
        return 1;
    }
}