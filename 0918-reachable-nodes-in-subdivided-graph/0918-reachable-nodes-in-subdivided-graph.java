class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
            adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[0] = 0;
        pq.offer(new int[]{0 , 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(weight+distance+1 < d[adjnode]){
                    d[adjnode] = weight+distance+1;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(d[i] <= maxMoves)
                ans++;
        }
        for(int i = 0; i < edges.length; i++){
            int x = Math.max(0 , maxMoves-d[edges[i][0]]);
            int y = Math.max(0 , maxMoves-d[edges[i][1]]);
            ans += Math.min(edges[i][2] , x+y);
        }
        return ans;
    }
}