class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    public long minCost(int m, int n, int[][] penalty) {
        long[][][] d = new long[m][n][2];
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((x , y)->Long.compare(x[0] , y[0]));
        for(long[][] a : d){
            for(long[] b : a){
                Arrays.fill(b , (long)(1e17));
            }
        }
        d[0][0][1] = 1;
        pq.offer(new long[]{1 , 0 , 0 , 1});
        while(!pq.isEmpty()){
            int r = (int)pq.peek()[1];
            int c = (int)pq.peek()[2];
            int p = (int)pq.peek()[3];
            long cost = pq.peek()[0];
            pq.poll();
            if(r == m-1 && c == n-1)
            return cost;
            if(cost > d[r][c][p])
            continue;
            if(d[r][c][(p+1)%2] > cost+penalty[r][c]){
                d[r][c][(p+1)%2] = cost+penalty[r][c];
                pq.offer(new long[]{d[r][c][(p+1)%2] , r , c , (p+1)%2});
            }
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < m && nr >= 0 && nc < n && nc >= 0){
                    long ncost = (long)((long)(nr+1)*(long)(nc+1));
                    if(p%2 == 1){
                        if(i > 1)
                        ncost += penalty[r][c];
                    }else{
                        if(i < 2)
                        ncost += penalty[r][c];
                    }
                    if(d[nr][nc][(p+1)%2] > cost+ncost){
                        d[nr][nc][(p+1)%2] = cost+ncost;
                        pq.offer(new long[]{d[nr][nc][(p+1)%2] , nr , nc , (p+1)%2});
                    }
                }
            }
        }
        return -1;
    }
}