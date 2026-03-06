class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    void DFS(int[][] grid , int r , int c , boolean[][] visited , List<int[]> l){
        visited[r][c] = true;
        l.add(new int[]{r , c});
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == grid[r][c])
            DFS(grid , nr , nc , visited , l);
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = grid[i].clone();
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<int[]> l = new ArrayList<>();
        DFS(grid , row , col , visited , l);
        for(int[] a : l){
            int c = 0;
            for(int i = 0; i < 4; i++){
                int nr = a[0]+dR[i];
                int nc = a[1]+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == grid[a[0]][a[1]])
                c++;
            }
            if(c != 4)
            ans[a[0]][a[1]] = color;
        }
        return ans;
    }
}