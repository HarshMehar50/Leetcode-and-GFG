class Solution {
    class Pair{
        long distance;
        int node;
        public Pair(long distance , int node){
            this.distance = distance;
            this.node = node;
        }
    }
    int mod = 1000000007;
    public int countPaths(int n, int[][] roads) {
        HashMap<Integer , List<Pair>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][2] , roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2] , roads[i][0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y)->Long.compare(x.distance , y.distance));
        long[] d = new long[n];
        long[] ways = new long[n];
        Arrays.fill(d , Long.MAX_VALUE);
        d[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0 , 0));
        while(!pq.isEmpty()){
            long distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                long weight = adj.get(node).get(i).distance;
                int adjnode = adj.get(node).get(i).node;
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new Pair(d[adjnode] , adjnode));
                    ways[adjnode] = ways[node];
                }else if(weight+distance == d[adjnode]){
                    ways[adjnode] = (ways[adjnode]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}