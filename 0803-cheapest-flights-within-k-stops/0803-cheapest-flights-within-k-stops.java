class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1] , flights[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[1] , y[1]));
        int[][] d = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        d[src][0] = 0;
        d[src][1] = 0;
        pq.offer(new int[]{0 , 0 , src});
        while(!pq.isEmpty()){
            int nv = pq.peek()[0];
            int cost = pq.peek()[1];
            int node = pq.peek()[2];
            pq.poll();
            if(node == dst && nv <= k+1){
            return cost;
            }
            if(nv > k) continue;
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[1];
                int adjnode = adj.get(node).get(i)[0];
                int v = nv+1;
                if(v < d[adjnode][0] || weight+cost < d[adjnode][1]){
                    d[adjnode][0] = v;
                    d[adjnode][1] = weight+cost;
                    pq.offer(new int[]{v , d[adjnode][1] , adjnode});
                }
            }
        }
        return -1;
    }
}