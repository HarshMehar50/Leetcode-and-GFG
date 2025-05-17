class Solution {
    class Pair{
        double probability;
        int node;
        public Pair(double probability , int node){
            this.probability = probability;
            this.node = node;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer , List<Pair>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(succProb[i] , edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(succProb[i] , edges[i][0]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y)->Double.compare(y.probability , x.probability));
        double[] p = new double[n];
        Arrays.fill(p , Double.MIN_VALUE);
        p[start_node] = 1;
        pq.offer(new Pair(1 , start_node));
        while(pq.size() != 0){
            double prob = pq.peek().probability;
            int cnode = pq.peek().node;
            pq.remove();
            for(int i = 0; i < adj.get(cnode).size(); i++){
                double cprob = adj.get(cnode).get(i).probability;
                int adjnode = adj.get(cnode).get(i).node;
                if(prob*cprob > p[adjnode]){
                    p[adjnode] = prob*cprob;
                    pq.add(new Pair(p[adjnode] , adjnode));
                }
            }
        }
        return p[end_node];
    }
}