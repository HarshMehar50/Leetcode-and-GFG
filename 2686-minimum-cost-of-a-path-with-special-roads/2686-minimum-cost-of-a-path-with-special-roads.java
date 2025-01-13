class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int[] d = new int[specialRoads.length+1];
        Arrays.fill(d , Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[2] , y[2]));
        pq.offer(new int[]{start[0] , start[1] , 0});
        while(!pq.isEmpty()){
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            int cost = pq.peek()[2];
            pq.poll();
            if(x == target[0] && y == target[1])
            return cost;
            for(int i = 0; i < specialRoads.length; i++){
                int nc = Math.abs(x-specialRoads[i][0])+Math.abs(y-specialRoads[i][1])+specialRoads[i][4];
                if(nc+cost < d[i]){
                    d[i] = nc+cost;
                    pq.offer(new int[]{specialRoads[i][2] , specialRoads[i][3] , nc+cost});
                }
            }
            int nc = Math.abs(x-target[0])+Math.abs(y-target[1]);
            if(nc+cost < d[specialRoads.length]){
                d[specialRoads.length] = nc+cost;
                pq.offer(new int[]{target[0] , target[1] , nc+cost});
            }
        }
        return -1;
    }
}