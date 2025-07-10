class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    boolean solve(char[][] board , String word , int r , int c , boolean[][] visited , int i){
        if(i == word.length())
            return true;
        if(r >= board.length || r < 0 || c >= board[0].length || c < 0 || visited[r][c] || board[r][c] != word.charAt(i))
            return false;
        visited[r][c] = true;
        for(int j = 0; j < 4; j++){
            int nr = r+dR[j];
            int nc = c+dC[j];
            if(solve(board , word , nr , nc , visited , i+1))
                return true;
        }
        visited[r][c] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        List<int[]> s = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0))
                    s.add(new int[]{i , j});
            }
        }
        for(int i = 0; i < s.size(); i++){
            boolean[][] visited = new boolean[board.length][board[0].length];
            if(solve(board , word , s.get(i)[0] , s.get(i)[1] , visited , 0))
                return true;
        }
        return false;
    }
}