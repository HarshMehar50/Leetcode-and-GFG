class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i , j});
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                for(int j = 0; j < 4; j++){
                    int nr = r+dR[j];
                    int nc = c+dC[j];
                    if(nr < grid.length && nr >= 0 && nc >= 0 && nc < grid[0].length){
                        if(!visited[nr][nc] && grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            q.offer(new int[]{nr , nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            ans++;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                return -1;
            }
        }
        return Math.max(0 , ans-1);
    }
}