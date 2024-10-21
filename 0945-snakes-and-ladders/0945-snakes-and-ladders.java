class Solution {
    public int snakesAndLadders(int[][] board) {
        int[] b = new int[(board.length*board.length)+1];
        int t = 0;
        for(int i = board.length-1; i >= 0; i--){
            t = board.length-1-i;
            if(t%2 == 0){
                for(int j = 0; j < board.length; j++){
                    if(board[i][j] != -1)
                    b[(board.length)*(board.length-1-i)+j+1] = board[i][j];
                    else
                    b[(board.length)*(board.length-1-i)+j+1] = 0;
                }
            }else{
                for(int j = board.length-1; j >= 0; j--){
                    if(board[i][j] != -1)
                    b[(board.length)*(board.length-1-i)+(board.length-1-j)+1] = board[i][j];
                    else
                    b[(board.length)*(board.length-1-i)+(board.length-1-j)+1] = 0;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[b.length];
        q.offer(new int[]{0 , 1 , b[1]});
        visited[1] = true;
        while(!q.isEmpty()){
            int c = q.peek()[0];
            int index = q.peek()[1];
            int n = q.peek()[2];
            q.poll();
            if(index == board.length*board.length)
            return c;
            for(int i = 1; i <= 6; i++){
                if(index+i < b.length){
                    int des = b[index+i]!=0?b[index+i]:(index+i);
                    if(!visited[des]){
                        visited[des] = true;
                        q.offer(new int[]{c+1 , des , b[des]});
                    }
                }
            }
        }
        return -1;
    }
}