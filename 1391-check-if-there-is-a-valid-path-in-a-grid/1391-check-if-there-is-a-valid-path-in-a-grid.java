class Solution {
    public boolean hasValidPath(int[][] grid) {
        /*Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int l = grid.length;
        int w = grid[0].length;
        q.offer(new int[]{0 , 0 , grid[0][0]});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int n = q.peek()[2];
            q.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
                return true;
            int nr1 = 0;
            int nc1 = 0;
            int nr2 = 0;
            int nc2 = 0;
            if(n == 1){
                nr1 = r;
                nc1 = c-1;
                nr2 = r;
                nc2 = c+1;
            }else if(n == 2){
                nr1 = r-1;
                nc1 = c;
                nr2 = r+1;
                nc2 = c;
            }else if(n == 3){
                nr1 = r;
                nc1 = c-1;
                nr2 = r+1;
                nc2 = c;
            }else if(n == 4){
                nr1 = r;
                nc1 = c+1;
                nr2 = r+1;
                nc2 = c;
            }else if(n == 5){
                nr1 = r;
                nc1 = c-1;
                nr2 = r-1;
                nc2 = c;
            }else{
                nr1 = r;
                nc1 = c+1;
                nr2 = r-1;
                nc2 = c;
            }
            if(nr1 < grid.length && nr1 >= 0 && nc1 < grid[0].length && nc1 >= 0 && !visited[nr1][nc1]){
                if((n == 1 && grid[nr1][nc1] == 2)||(n == 2 && grid[nr1][nc1] == 1)) continue;
                q.offer(new int[]{nr1 , nc1 , grid[nr1][nc1]});
                visited[nr1][nc1] = true;
            }
            if(nr2 < grid.length && nr2 >= 0 && nc2 < grid[0].length && nc2 >= 0 && !visited[nr2][nc2]){
                if((n == 1 && grid[nr2][nc2] == 2)||(n == 2 && grid[nr2][nc2] == 1)||(n == 5 && grid[nr2][nc2] == 6)) continue;
                q.offer(new int[]{nr2 , nc2 , grid[nr2][nc2]});
                visited[nr2][nc2] = true;
            }
        }
        return false;*/
        int m = grid.length, n = grid[0].length;

  
    int[][][] dirs = {
        {},
        {{0, -1}, {0, 1}},     
        {{-1, 0}, {1, 0}},     
        {{0, -1}, {1, 0}},     
        {{0, 1}, {1, 0}},      
        {{0, -1}, {-1, 0}},    
        {{0, 1}, {-1, 0}}      
    };

    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];

    q.offer(new int[]{0, 0});
    visited[0][0] = true;

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int r = cur[0], c = cur[1];

        if (r == m - 1 && c == n - 1) return true;

        int type = grid[r][c];

        for (int[] d : dirs[type]) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
                continue;

            int nextType = grid[nr][nc];
            for (int[] back : dirs[nextType]) {
                if (nr + back[0] == r && nc + back[1] == c) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    break;
                }
            }
        }
    }

    return false;
    }
}