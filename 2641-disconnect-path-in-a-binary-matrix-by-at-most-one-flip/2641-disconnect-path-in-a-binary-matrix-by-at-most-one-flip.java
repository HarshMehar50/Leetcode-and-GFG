class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    /*void cDFS(int[][] grid , boolean[][] visited , int r , int c , int k){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == k && !visited[nr][nc])
            cDFS(grid , visited , nr , nc , k);
        }
    }
    int components(int[][] grid , int k){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int c = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == k){
                    c++;
                    cDFS(grid , visited , i , j , k);
                }
            }
        }
        return c;
    }
    void DFS(int r , int c , int pr , int pc , int timer , int[][] discover , int[][] low , int[] count , boolean[][] visited , int[][] grid){
        visited[r][c] = true;
        discover[r][c] = low[r][c] = timer++;
        int child = 0;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1){
                if(pr == nr && pc == nc) continue;
                if(!visited[nr][nc]){
                    DFS(nr , nc , r , c , timer , discover , low , count , visited , grid);
                    low[r][c] = Math.min(low[r][c] , low[nr][nc]);
                    if(low[nr][nc] >= discover[r][c] && (pr != -1 && pc != -1))
                    count[0]++;
                    child++;
                }else
                low[r][c] = Math.min(low[r][c] , discover[nr][nc]);
            }
        }
        if((pr == -1 && pc == -1) && child > 1)
        count[0]++;
    }*/
    boolean DFS(int[][] grid , int i , int j){
        if(i+1 == grid.length && j+1 == grid[0].length)
            return true;
        if(i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return false;
        grid[i][j] = 0;
        boolean ans = DFS(grid , i+1 , j)||DFS(grid , i , j+1);
        return ans;
    }
    public boolean isPossibleToCutPath(int[][] grid) {
        /*int comp0 = components(grid , 0);
        int comp1 = components(grid , 1);
        if(comp0 > 1 || comp1 > 1)
        return true;
        int count[] = {0};
        int[][] discover = new int[grid.length][grid[0].length];
        int[][] low = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(discover[i] , -1);
            Arrays.fill(low[i] , -1);
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int timer = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1)
                DFS(i , j , -1 , -1 , timer , discover , low , count , visited , grid);
            }
        }
        if(count[0] >= 1)
        return true;
        else
        return false;*/
        if(!DFS(grid , 0 , 0))
            return true;
        grid[0][0] = 1;
        return !DFS(grid , 0 , 0);
    }
}