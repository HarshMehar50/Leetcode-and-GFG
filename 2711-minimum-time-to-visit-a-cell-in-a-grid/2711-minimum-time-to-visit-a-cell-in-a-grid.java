class Solution {
    public int minimumTime(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if(grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        pq.offer(new int[]{grid[0][0] , 0 , 0});
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int time = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
                return time;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc]){
                    if(grid[nr][nc] <= time+1)
                        pq.offer(new int[]{time+1 , nr , nc});
                    else{
                        if((grid[nr][nc]-time)%2 == 1)
                            pq.offer(new int[]{grid[nr][nc] , nr , nc});
                        else
                            pq.offer(new int[]{grid[nr][nc]+1 , nr , nc});
                    }
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}