class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        int chealth = health-grid.get(0).get(0);
        if(chealth <= 0)
            return false;
        int[][] d = new int[grid.size()][grid.get(0).size()];
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MIN_VALUE);
        }
        pq.offer(new int[]{chealth , 0 , 0});
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        d[0][0] = chealth;
        while(!pq.isEmpty()){
            int ch = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r == grid.size()-1 && c == grid.get(0).size()-1 && ch >= 1)
                return true;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.size() && nr >= 0 && nc < grid.get(0).size() && nc >= 0)
                    if(ch-grid.get(nr).get(nc) > d[nr][nc] && ch-grid.get(nr).get(nc) > 0){
                        d[nr][nc] = ch-grid.get(nr).get(nc);
                        pq.offer(new int[]{ch-grid.get(nr).get(nc) , nr , nc});
                    }
            }
        }
        return false;
    }
}