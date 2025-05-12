class Solution {
    void DFS(int r , int c , boolean[][] visited , char[][] board , int[] dR , int[] dC){
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr < board.length && nr >= 0 && nc < board[0].length && nc >= 0 && !visited[nr][nc] && board[nr][nc] == 'O')
                DFS(nr , nc , visited , board , dR , dC);
        }
    }
    public void solve(char[][] board) {
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int j = 0; j < board[0].length; j++){
            if(!visited[0][j] && board[0][j] == 'O')
                DFS(0 , j , visited , board , dR , dC);
            if(!visited[board.length-1][j] && board[board.length-1][j] == 'O')
                DFS(board.length-1 , j , visited , board , dR , dC);
        }
        for(int i = 0; i < board.length; i++){
            if(!visited[i][0] && board[i][0] == 'O')
                DFS(i , 0 , visited , board , dR , dC);
            if(!visited[i][board[0].length-1] && board[i][board[0].length-1] == 'O')
                DFS(i , board[0].length-1 , visited , board , dR , dC);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(!visited[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}