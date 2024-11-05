class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        q.offer(new int[]{entrance[0] , entrance[1]});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            int s = q.size();
            for(int j = 0; j < s; j++){
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                if((r == 0 || r == maze.length-1 || c == 0 || c == maze[0].length-1)&&(r != entrance[0] || c != entrance[1]))
                return ans;
                for(int i = 0; i < 4; i++){
                    int nr = r+dR[i];
                    int nc = c+dC[i];
                    if(nr < maze.length && nr >= 0 && nc < maze[0].length && nc >= 0 && !visited[nr][nc] && maze[nr][nc] != '+'){
                        q.offer(new int[]{nr , nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}