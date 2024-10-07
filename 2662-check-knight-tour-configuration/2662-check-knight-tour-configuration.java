class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dR = {-2 , -2 , -1 , -1 , 1 , 1 , 2 , 2};
        int[] dC = {-1 , 1 , -2 , 2 , -2 , 2 , -1 , 1};
        if(grid[0][0] != 0)
        return false;
        q.offer(new int[]{grid[0][0] , 0 , 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int val = q.peek()[0];
            int r = q.peek()[1];
            int c = q.peek()[2];
            q.poll();
            if(val == grid.length*grid.length-1)
            return true;
            for(int i = 0; i < 8; i++){
                int nv = val+1;
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >=  0 && nc < grid.length && nc >=  0)
                if(grid[nr][nc] == nv && !visited[nr][nc]){
                    q.offer(new int[]{nv , nr, nc});
                    visited[nr][nc] = true;
                    break;
                }
            }
        }
        return false;
    }
}