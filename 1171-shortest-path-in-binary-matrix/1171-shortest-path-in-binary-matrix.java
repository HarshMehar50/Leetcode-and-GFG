class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
        return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{0 , 0 , 0});
        int[] dR = {1 , 0 , -1 , 0 , 1 , 1 , -1 , -1};
        int[] dC = {0 , 1 , 0 , -1 , 1 , -1 , 1 , -1};
        int[][] d = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return distance+1;
            for(int i = 0; i < 8; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length){
                    if(grid[nr][nc] == 0 && 1+distance < d[nr][nc]){
                        d[nr][nc] = 1+distance;
                        pq.offer(new int[]{d[nr][nc] , nr , nc});
                    }
                }
            }
        }
        return -1;
    }
}