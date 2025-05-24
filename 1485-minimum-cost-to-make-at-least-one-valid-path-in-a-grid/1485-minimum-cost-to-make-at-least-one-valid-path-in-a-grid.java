class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[2] , y[2]));
        int[][] d = new int[grid.length][grid[0].length];
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        int[] dR = {0 , 0 , 1 , -1};
        int[] dC = {1 , -1 , 0 , 0};
        pq.offer(new int[]{0 , 0 , 0});
        d[0][0] = 0;
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int cost = pq.peek()[2];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
                return cost;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                    if(i+1 == grid[r][c]){
                        if(0+cost < d[nr][nc]){
                            d[nr][nc] = 0+cost;
                            pq.offer(new int[]{nr , nc , d[nr][nc]});
                        }
                    }else{
                        if(1+cost < d[nr][nc]){
                            d[nr][nc] = 1+cost;
                            pq.offer(new int[]{nr , nc , d[nr][nc]});
                        }
                    }
                }
            }
        }
        return -1;
    }
}