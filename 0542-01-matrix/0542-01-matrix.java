class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = 0; i < ans.length; i++){
            Arrays.fill(ans[i] , Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i , j});
                    ans[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < mat.length && nr >= 0 && nc < mat[0].length && nc >= 0){
                    if(ans[nr][nc] > ans[r][c]+1){
                        ans[nr][nc] = ans[r][c]+1;
                        q.offer(new int[]{nr , nc});
                    }
                }
            }
        }
        return ans;
    }
}