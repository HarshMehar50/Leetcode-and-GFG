class Solution {
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[][] d = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        pq.offer(new int[]{0 , 0 , 0});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && distance+grid[nr][nc] < d[nr][nc]){
                    d[nr][nc] = distance+grid[nr][nc];
                    pq.offer(new int[]{d[nr][nc] , nr , nc});
                }
            } 
        }
        return d[grid.length-1][grid[0].length-1];
    }
}