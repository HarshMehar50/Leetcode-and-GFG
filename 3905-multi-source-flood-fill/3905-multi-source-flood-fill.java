class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        Arrays.sort(sources , (x , y)->Integer.compare(y[2] , x[2]));
        for(int[] a : sources){
            ans[a[0]][a[1]] = a[2];
            q.offer(new int[]{a[0] , a[1] , a[2]});
            visited[a[0]][a[1]] = true;
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            int l = q.size();
            //for(int i = 0; i < l; i++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                int color = q.peek()[2];
                q.poll();
                for(int j = 0; j < 4; j++){
                    int nr = r+dR[j];
                    int nc = c+dC[j];
                    if(nr < n && nc < m && nr >= 0 && nc >= 0 && !visited[nr][nc]){
                        ans[nr][nc] = color;
                        q.offer(new int[]{nr , nc , ans[nr][nc]});
                        visited[nr][nc] = true;
                    }
                }
            //}
        }
        return ans;
    }
}