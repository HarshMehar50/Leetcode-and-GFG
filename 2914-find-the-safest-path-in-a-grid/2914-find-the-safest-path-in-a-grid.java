class Solution {
    boolean check(int[][] d , int m){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[d.length][d[0].length];
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        q.offer(new int[]{0 , 0});
        visited[0][0]= true;
        if(d[0][0] < m)
        return false;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            if(r == d.length-1 && c == d[0].length-1)
            return true;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < d.length && nr >= 0 && nc < d[0].length && nc >= 0 && !visited[nr][nc]){
                    if(d[nr][nc] < m) continue;
                    q.offer(new int[]{nr , nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] d = new int[grid.size()][grid.get(0).size()];
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid.get(0).size(); j++){
                if(grid.get(i).get(j) == 1){
                    q.offer(new int[]{i , j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        int level = 0;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                d[r][c] = level;
                for(int j = 0; j < 4; j++){
                    int nr = r+dR[j];
                    int nc = c+dC[j];
                    if(nr >= 0 && nr < grid.size() && nc >= 0 && nc < grid.get(0).size() && !visited[nr][nc]){
                        q.offer(new int[]{nr , nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            level++;
        }
        int s = 0;
        int e = 400;
        int ans = 0;
        while(s <= e){
            int m = s+(e-s)/2;
            if(check(d , m)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
}