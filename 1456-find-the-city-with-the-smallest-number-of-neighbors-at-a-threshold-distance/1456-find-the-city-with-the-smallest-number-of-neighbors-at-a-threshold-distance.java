class Solution {
    int[] dijkstra(HashMap<Integer , List<int[]>> adj , int s){
        int[] d = new int[adj.size()];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{0 , s});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
            adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int[] d = dijkstra(adj , i);
            for(int j = 0; j < n; j++){
                if(d[j] <= distanceThreshold)
                ans[j]++;
            }
        }
        int city = Integer.MAX_VALUE;
        int cityi = -1;
        for(int i = 0; i < n; i++){
            if(city >= ans[i]){
            city = ans[i];
            cityi = i;
            }
        }
        return cityi;
    }
}