class Solution {
    public int numEnclaves(int[][] grid) {
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if((i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) && grid[i][j] == 1){
                    q.offer(new int[]{i , j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == 1){
                    q.offer(new int[]{nr , nc});
                    visited[nr][nc] = true;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j])
                    ans++;
            }
        }
        return ans;
    }
}