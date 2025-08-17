class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    boolean predicate(int[][] time , int[][] grid , int st){
        /*if(st >= time[0][0])
        return false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , 0 , st});
        visited[0][0] = true;
        int[][] d = new int[time.length][time[0].length];
        for(int[] a : d){
            Arrays.fill(a , Integer.MAX_VALUE);
        }
        d[0][0] = st;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.poll();
            if(r == grid.length-1 && c == grid[0].length-1){
                if(t <= time[r][c])
                return true;
                else
                return false;
            }
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                int nt = t+1;
                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) continue;
                if(grid[nr][nc] == 2 || visited[nr][nc]) continue;
                if(nt < time[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr , nc , nt});
                }
            }
        }
        return false;*/
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        q.offer(new int[]{0 , 0 , st});
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] != 2){
                    if(nr == grid.length-1 && nc == grid[0].length-1 && time[nr][nc] >= t+1)
                    return true;
                    if(time[nr][nc] > t+1){
                        q.offer(new int[]{nr , nc , t+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return false;
    }
    public int maximumMinutes(int[][] grid) {
        int[][] time = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int level = 0;
        for(int[] a : time){
            Arrays.fill(a , Integer.MAX_VALUE);
        }
        Queue<int[]> qt = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    qt.offer(new int[]{i , j});
                    time[i][j] = level;
                    visited[i][j] = true;
                }
            }
        }
        while(!qt.isEmpty()){
            int l = qt.size();
            for(int i = 0; i < l; i++){
                int r = qt.peek()[0];
                int c = qt.peek()[1];
                qt.poll();
                for(int j = 0; j < 4; j++){
                    int nr = r+dR[j];
                    int nc = c+dC[j];
                    if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && !visited[nr][nc] && grid[nr][nc] == 0){
                        qt.offer(new int[]{nr , nc});
                        time[nr][nc] = level+1;
                        visited[nr][nc] = true;
                    }
                }
            }
            level++;
        }
        int s = 0;
        int ans = -1;
        int e = (int)1e9;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(time , grid , m)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
}