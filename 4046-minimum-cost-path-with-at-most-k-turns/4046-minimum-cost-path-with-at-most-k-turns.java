class Solution {
    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};
    public int minCost(int[][] grid, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[][][][] d = new int[grid.length][grid[0].length][k+1][5];
        for(int[][][] a : d){
            for(int[][] b : a){
                for(int[] c : b){
                    Arrays.fill(c , Integer.MAX_VALUE);
                }
            }
        }
        d[0][0][k][0] = grid[0][0];
        pq.offer(new int[]{d[0][0][k][0] , 0 , 0 , k , -1});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            int rk = pq.peek()[3];
            int pm = pq.peek()[4];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return distance;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                    int rt = rk;
                    if(pm != -1 && (pm != i))
                    rt--;
                    if(rt >= 0 && d[nr][nc][rt][i+1] > d[r][c][rk][pm+1]+grid[nr][nc]){
                        d[nr][nc][rt][i+1] = d[r][c][rk][pm+1]+grid[nr][nc];
                        pq.offer(new int[]{d[nr][nc][rt][i+1] , nr , nc , rt , i});
                    }
                }
            }
        }
        return -1;
    }
}