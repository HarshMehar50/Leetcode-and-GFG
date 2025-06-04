class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x , y)->Integer.compare(x[2] , y[2]));
        int[][] visited = new int[grid.length][grid[0].length];
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        q.offer(new int[]{0 , 0 , 0});
        for(int i = 0; i < visited.length; i++){
            Arrays.fill(visited[i] , Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return t;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && visited[nr][nc] > Math.max(t , grid[nr][nc])){
                    q.offer(new int[]{nr , nc , Math.max(t , grid[nr][nc])});
                    visited[nr][nc] = Math.max(t , grid[nr][nc]);
                }
            }
        }
        return -1;
    }
}