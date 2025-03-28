class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    /*void DFS(int[][] grid , boolean[][] visited , int r , int c , int v){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] < v)
            DFS(grid , visited , nr , nc , v);
        }
    }*/
    public int[] maxPoints(int[][] grid, int[] queries) {
        /*int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(grid[0][0] >= queries[i])
            ans[i] = 0;
            else{
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                DFS(grid , visited , 0 , 0 , queries[i]);
                for(int j = 0; j < visited.length; j++){
                    for(int k = 0; k < visited[0].length; k++){
                        if(visited[j][k])
                        ans[i]++;
                    }
                }
            }
        }
        return ans;*/
        int[] ans = new int[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[][] a = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            a[i][0] = queries[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{grid[0][0] , 0 , 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int s = 0;
        for(int i = 0; i < a.length; i++){
            while(!pq.isEmpty() && pq.peek()[0] < a[i][0]){
                int r = pq.peek()[1];
                int c = pq.peek()[2];
                pq.poll();
                s++;
                for(int j = 0; j < 4; j++){
                    int nr = r+dR[j];
                    int nc = c+dC[j];
                    if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc]){
                        pq.offer(new int[]{grid[nr][nc] , nr , nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            ans[a[i][1]] = s;
        }
        return ans;
    }
}