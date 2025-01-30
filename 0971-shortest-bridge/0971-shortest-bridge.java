class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    void DFS(int r , int c , boolean[][] visited , int[][] grid , List<int[]> l){
        visited[r][c] = true;
        l.add(new int[]{r , c});
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == 1)
            DFS(nr , nc , visited , grid , l);
        }
    }
    public int shortestBridge(int[][] grid) {
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int sr1 = -1;
        int sc1 = -1;
        int sr2 = -1;
        int sc2 = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    sr1 = i;
                    sc1 = j;
                    break;
                }
            }
        }
        DFS(sr1 , sc1 , visited , grid , l1);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    sr2 = i;
                    sc2 = j;
                    break;
                }
            }
        }
        DFS(sr2 , sc2 , visited , grid , l2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < l1.size(); i++){
            for(int j = 0; j < l2.size(); j++){
                ans = Math.min(ans , Math.abs(l1.get(i)[0]-l2.get(j)[0])+Math.abs(l1.get(i)[1]-l2.get(j)[1]));
            }
        }
        return ans-1;
    }
}