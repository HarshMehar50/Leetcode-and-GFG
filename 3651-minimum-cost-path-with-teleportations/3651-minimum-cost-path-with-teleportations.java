class Solution {
    public int minCost(int[][] grid, int k) {
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                l.add(new int[]{grid[i][j] , i , j});
            }
        }
        Collections.sort(l , (x , y)->Integer.compare(x[0] , y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[][][] d = new int[grid.length][grid[0].length][k+1];
        for(int[][] a : d){
            for(int[] b : a){
                Arrays.fill(b , Integer.MAX_VALUE);
            }
        }
        int[] visited = new int[k+1];
        pq.offer(new int[]{0 , 0 , 0 , k});
        d[0][0][k] = 0;
        while(!pq.isEmpty()){
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            int rt = pq.peek()[3];
            int cost = pq.peek()[0];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return cost;
            if(r+1 < grid.length){
                if(cost+grid[r+1][c] < d[r+1][c][rt]){
                    d[r+1][c][rt] = cost+grid[r+1][c];
                    pq.offer(new int[]{d[r+1][c][rt] , r+1 , c , rt});
                }
            }
            if(c+1 < grid[0].length){
                if(cost+grid[r][c+1] < d[r][c+1][rt]){
                    d[r][c+1][rt] = cost+grid[r][c+1];
                    pq.offer(new int[]{d[r][c+1][rt] , r , c+1 , rt});
                }
            }
            /*for(int[] a : l){
                if(a[0] <= grid[r][c]){
                    if(rt-1 >= 0 && d[a[1]][a[2]][rt-1] > cost){
                        d[a[1]][a[2]][rt-1] = cost;
                        pq.offer(new int[]{d[a[1]][a[2]][rt-1] , a[1] , a[2] , rt-1});
                    }
                }
            }*/
            if(rt > 0){
                int r1 = visited[rt];
                while(r1 < l.size()){
                    int[] a = l.get(r1);
                    if(a[0] > grid[r][c])
                    break;
                    if(cost < d[a[1]][a[2]][rt-1]){
                        d[a[1]][a[2]][rt-1] = cost;
                        pq.offer(new int[]{d[a[1]][a[2]][rt-1] , a[1] , a[2] , rt-1});
                    }
                    r1++;
                }
                visited[rt] = r1;
            }
        }
        return -1;
    }
}