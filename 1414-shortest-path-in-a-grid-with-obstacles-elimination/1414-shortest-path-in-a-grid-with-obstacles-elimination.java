class Solution {
    /*PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[3] , y[3]));
        int[][] d = new int[grid.length][grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];
        pq.offer(new int[]{0 , 0 , 0 , 0});
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        d[0][0] = 0;
        ans[0][0] = 0;
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        while(!pq.isEmpty()){
            int r = pq.peek()[0];
            int c = pq.peek()[1];
            int distance = pq.peek()[2];
            int obstaclesRemoved = pq.peek()[3];
            pq.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                    if(obstaclesRemoved+grid[nr][nc] < d[nr][nc]){
                        d[nr][nc] = obstaclesRemoved+grid[nr][nc];
                        ans[nr][nc] = distance+1;
                        pq.offer(new int[]{nr , nc , ans[nr][nc] , d[nr][nc]});
                    }
                }
            }
        }
        if(d[grid.length-1][grid[0].length-1] <= k)
        return ans[grid.length-1][grid[0].length-1];
        else
        return -1;*/
    public int shortestPath(int[][] grid, int k) {
        /*Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] a = new int[grid.length][grid[0].length];
        q.offer(new int[]{0 , 0 , k , 0});
        visited[0][0] = true;
        for(int i = 0; i < a.length; i++){
            Arrays.fill(a[i] , -1);
        }
        a[0][0] = k;
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int or = q.peek()[2];
            int d = q.peek()[3];
            q.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return d;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && a[nr][nc] == -1){
                    if(or-grid[nr][nc] >= 0 && or-grid[nr][nc] > a[nr][nc]){
                    q.offer(new int[]{nr , nc , or-grid[nr][nc] , d+1});
                    visited[nr][nc] = true;
                    a[nr][nc] = or-grid[nr][nc];
                    }
                }
            }
        }
        return -1;*/
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < visited.length; i++){
            Arrays.fill(visited[i] , -1);
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        q.offer(new int[]{0 , 0 , 0 , k});
        visited[0][0] = k;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int d = q.peek()[2];
            int or = q.peek()[3];
            q.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
                return d;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                    if(or-grid[nr][nc] > visited[nr][nc] && or-grid[nr][nc] >= 0){
                        q.offer(new int[]{nr , nc , d+1 , or-grid[nr][nc]});
                        visited[nr][nc] = or-grid[nr][nc];
                    }
                }
            }
        }
        return -1;
    }
}