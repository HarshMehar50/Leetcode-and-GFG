class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze[entrance[0]][entrance[1]] == '+')
        return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        q.offer(new int[]{entrance[0] , entrance[1] , 0});
        visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int d = q.peek()[2];
            q.poll();
            if((r == 0 || r == maze.length-1 || c == 0 || c == maze[0].length-1)&&!(r == entrance[0] && c == entrance[1]))
            return d;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && !visited[nr][nc] && maze[nr][nc] == '.'){
                    q.offer(new int[]{nr , nc , d+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1; 
    }
}