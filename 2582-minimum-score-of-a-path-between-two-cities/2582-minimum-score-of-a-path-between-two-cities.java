class Solution {
    int dijkstra(HashMap<Integer , List<int[]>> adj , int src , int des , int n){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n+1];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[src] = Integer.MAX_VALUE;
        pq.offer(new int[]{Integer.MAX_VALUE , src});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            /*if(node == des){
            return distance;
            }*/
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(Math.min(weight , distance) < d[adjnode]){
                    d[adjnode] = Math.min(weight , distance);
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d[n];
    }
    public int minScore(int n, int[][] roads) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new int[]{roads[i][2] , roads[i][1]});
            adj.get(roads[i][1]).add(new int[]{roads[i][2] , roads[i][0]});
        }
        int p1 = dijkstra(adj , 1 , n , n);
        int p2 = dijkstra(adj , n , 1 , n);
        return Math.min(p1 , p2);
    }
}