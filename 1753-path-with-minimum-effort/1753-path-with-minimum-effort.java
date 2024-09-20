class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] d = new int[heights.length][heights[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        int dR[] = {-1 , 0 , 1 , 0};
        int dC[] = {0 , 1 , 0 , -1};
        pq.offer(new int[]{0 , 0 , 0});
        d[0][0] = 0;
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r == heights.length-1 && c == heights[0].length-1){
                return distance;
            }
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < heights.length && nr >= 0 && nc < heights[0].length && nc >= 0){
                    if(Math.max(Math.abs(heights[r][c]-heights[nr][nc]) , distance) < d[nr][nc]){
                        d[nr][nc] = Math.max(Math.abs(heights[r][c]-heights[nr][nc]) , distance);
                        pq.offer(new int[]{d[nr][nc] , nr , nc});
                    }
                }
            }
        }
        return 0;
    }
}