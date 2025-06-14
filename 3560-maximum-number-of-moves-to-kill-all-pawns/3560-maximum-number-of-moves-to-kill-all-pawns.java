class Solution {
    int[] dR = {-2 , -2 , -1 , -1 , 1 , 1 , 2 , 2};
    int[] dC = {-1 , 1 , -2 , 2 , -2 , 2 , -1 , 1};
    void BFS(int r , int c , int i , int[][] mind , List<int[]> l){
        int[][] d = new int[50][50];
        for(int j = 0; j < d.length; j++){
            Arrays.fill(d[j] , -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r , c});
        d[r][c] = 0;
        while(!q.isEmpty()){
            int cr = q.peek()[0];
            int cc = q.peek()[1];
            q.poll();
            for(int j = 0; j < 8; j++){
                int nr = cr+dR[j];
                int nc = cc+dC[j];
                if(nr >= 0 && nr < 50 && nc >= 0 && nc < 50 && d[nr][nc] == -1){
                    d[nr][nc] = d[cr][cc]+1;
                    q.offer(new int[]{nr , nc});
                }
            }
        }
        for(int j = 0; j < l.size(); j++){
            mind[i][j] = d[l.get(j)[0]][l.get(j)[1]];
        }
    }
    int solve(int[][] mind , int i , int mask , int n , boolean alice){
        if(mask == 0)
        return 0;
        int ans = 0;
        if(alice)
        ans = -1;
        else
        ans = Integer.MAX_VALUE;
        for(int j = 1; j < n; j++){
            if((mask&(1<<(j-1))) != 0){
                if(alice)
                ans = Math.max(ans , mind[i][j]+solve(mind , j , mask^(1<<(j-1)) , n , !alice));
                else
                ans = Math.min(ans , mind[i][j]+solve(mind , j , mask^(1<<(j-1)) , n , !alice));
            }
        }
        return ans;
    }
    public int maxMoves(int kx, int ky, int[][] positions) {
        List<int[]> l = new ArrayList<>();
        l.add(new int[]{kx , ky});
        for(int i = 0; i < positions.length; i++){
            l.add(positions[i]);
        }
        int[][] mind = new int[positions.length+1][positions.length+1];
        for(int i = 0; i < l.size(); i++){
            BFS(l.get(i)[0] , l.get(i)[1] , i , mind , l);
        }
        return solve(mind , 0 , (1<<positions.length)-1 , l.size() , true);
    }
}