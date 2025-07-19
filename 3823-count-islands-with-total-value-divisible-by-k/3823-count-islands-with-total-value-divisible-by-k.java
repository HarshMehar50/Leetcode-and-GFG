class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    void DFS(int[][] grid , boolean[][] visited , int r , int c , int[] a){
        visited[r][c] = true;
        a[0] += grid[r][c];
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] != 0)
                DFS(grid , visited , nr , nc , a);
        }
    }
    public int countIslands(int[][] grid, int k) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    int[] a = {0};
                    DFS(grid , visited , i , j , a);
                    l.add(a[0]);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < l.size(); i++){
            if(l.get(i)%k == 0)
                ans++;
        }
        return  ans;
    }
}