class Solution {
    int[] dijkstra(int n , HashMap<Integer ,List<int[]>> adj , int s){
        int[] d = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        Arrays.fill(d , Integer.MAX_VALUE);
        d[s] = 0;
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
    public boolean[] findAnswer(int n, int[][] edges) {
        HashMap<Integer ,List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
            adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
        }
        int[] ds = dijkstra(n , adj , 0);
        int[] dd = dijkstra(n , adj , n-1);
        boolean[] ans = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(ds[edges[i][0]] != Integer.MAX_VALUE && ds[edges[i][1]] != Integer.MAX_VALUE && dd[edges[i][0]] != Integer.MAX_VALUE && dd[edges[i][1]] != Integer.MAX_VALUE)
                if((ds[edges[i][0]]+edges[i][2]+dd[edges[i][1]] == ds[n-1])||(ds[edges[i][1]]+edges[i][2]+dd[edges[i][0]] == ds[n-1]))
                    ans[i] = true;
        }
        return ans;
    }
}