class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        //Queue<long[]> q = new LinkedList<>();
        PriorityQueue<long[]> q = new PriorityQueue<long[]>((x , y)->Long.compare(x[3] , y[3]));
        boolean[][] visited = new boolean[m][n];
        q.offer(new long[]{0 , 0 , 1 , 1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int r = (int)q.peek()[0];
            int c = (int)q.peek()[1];
            long t = q.peek()[2];
            long cost = q.peek()[3];
            q.poll();
            if(r == m-1 && c == n-1)
                return cost;
            if(t%2 == 1){
                if(c+1 < n && !visited[r][c+1]){
                    q.offer(new long[]{r , c+1 , t+1 , cost+(long)((long)(r+1)*(long)(c+2))});
                    visited[r][c+1] = true;
                }
                if(r+1 < m && !visited[r+1][c]){
                    q.offer(new long[]{r+1 , c , t+1 , cost+(long)((long)(r+2)*(long)(c+1))});
                    visited[r+1][c] = true;
                }
            }else{
                q.offer(new long[]{r , c , t+1 , cost+waitCost[r][c]});
            }
        }
        return -1;
    }
}