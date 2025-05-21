class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x , y)->Integer.compare(x[0] , y[0]));
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];
        q.offer(new int[]{0 , 0 , 0 , moveTime[0][0]});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int time = q.peek()[0];
            int r = q.peek()[1];
            int c = q.peek()[2];
            int node = q.peek()[3];
            q.poll();
            if(r == moveTime.length-1 && c == moveTime[0].length-1)
                return time;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < moveTime.length && nr >= 0 && nc < moveTime[0].length && nc >= 0 && !visited[nr][nc]){
                    q.offer(new int[]{Math.max(time+1 , moveTime[nr][nc]+1) , nr , nc , moveTime[nr][nc]});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}