class Solution {
    class Pair{
        long distance;
        int node;
        public Pair(long distance , int node){
            this.distance = distance;
            this.node = node;
        }
    }
    long[] dijkstra(int n , HashMap<Integer , List<Pair>> adj , int src){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y)->Long.compare(x.distance , y.distance));
        long[] d = new long[n];
        Arrays.fill(d , Long.MAX_VALUE);
        d[src] = 0;
        pq.offer(new Pair(0 , src));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            long distance = pq.peek().distance;
            pq.poll();
            if(distance != d[node])
            continue;
            for(int i = 0; i < adj.get(node).size(); i++){
                long weight = adj.get(node).get(i).distance;
                int adjnode = adj.get(node).get(i).node;
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new Pair(d[adjnode] , adjnode));
                }
            }
        }
        return d;
    }
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        HashMap<Integer , List<Pair>> adj = new HashMap<>();
        HashMap<Integer , List<Pair>> adjr = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
            adjr.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][2] , edges[i][1]));
            adjr.get(edges[i][1]).add(new Pair(edges[i][2] , edges[i][0]));
        }
        long[] ds1 = dijkstra(n , adj , src1);
        long[] ds2 = dijkstra(n , adj , src2);
        long[] dd = dijkstra(n , adjr , dest);
        if(ds1[dest] == Long.MAX_VALUE || ds2[dest] == Long.MAX_VALUE)
        return -1;
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(ds1[i] != Long.MAX_VALUE && ds2[i] != Long.MAX_VALUE && dd[i] != Long.MAX_VALUE)
            ans = Math.min(ans , ds1[i]+ds2[i]+dd[i]);
        }
        if(ans != Long.MAX_VALUE)
        return ans;
        else
        return -1;
    }
}