class Solution {
    int dijkstra(int[][] edges , int n , int source , int destination , HashMap<Integer , List<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n];
        Arrays.fill(d , (int)(2*Math.pow(10 , 9)));
        d[source] = 0;
        pq.offer(new int[]{0 , source});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(distance+weight < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d[destination];
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][2] != -1){
                adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
                adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
            }
        }
        int csd = dijkstra(edges , n , source , destination , adj);
        if(csd < target)
        return new int[][]{};
        boolean track = (csd == target);
        for(int i = 0; i < edges.length; i++){
            if(edges[i][2] != -1) continue;
            edges[i][2] = track?(int)(2*Math.pow(10 , 9)):1;
            adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
            adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
            if(!track){
                int nsd = dijkstra(edges , n , source , destination , adj);
                if(nsd <= target){
                    track = true;
                    edges[i][2] += (target-nsd);
                }
            }
        }
        if(track)
        return edges;
        else
        return new int[][]{};
    }
}