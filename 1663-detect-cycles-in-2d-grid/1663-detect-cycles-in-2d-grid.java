class Solution {
    boolean BFS(char[][] grid , int sr , int sc , boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        q.offer(new int[]{sr , sc , -1 , -1});
        visited[sr][sc] = true;
        char val = grid[sr][sc];
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int pr = q.peek()[2];
            int pc = q.peek()[3];
            q.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == val){
                    if(visited[nr][nc] && !(nr == pr && nc == pc))
                    return true;
                    if(!visited[nr][nc]){
                        q.offer(new int[]{nr , nc , r , c});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j]){
                    if(BFS(grid , i , j , visited))
                    return true;
                }
            }
        }
        return false;
    }
}