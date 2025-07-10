class Solution {
    // Function to find all possible paths
    int[] dR = {1 , 0 , 0 , -1};
    int[] dC = {0 , -1 , 1 , 0};
    void solve(int[][] maze , boolean[][] visited , int r , int c , ArrayList<String> ans , String move){
        if(r == maze.length-1 && c == maze[0].length-1){
            ans.add(move);
            return;
        }
        char[] direction = {'D' , 'L' , 'R' , 'U'};
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && !visited[nr][nc] && maze[nr][nc] == 1){
                visited[r][c] = true;
                solve(maze , visited , nr , nc , ans , move+direction[i]);
                visited[r][c] = false;
            }
        }
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        solve(maze , visited , 0 , 0 , ans , "");
        return ans;
    }
}