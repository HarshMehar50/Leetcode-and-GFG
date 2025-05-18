class Solution {
    final int mod = 1000000007;
    int DFS(HashMap<Integer , List<int[]>> adj , int[] d , int[] dp , int node){
        if(node == adj.size())
            return 1;
        if(dp[node] != -1)
            return dp[node];
        long ans = 0;
        for(int i = 0; i < adj.get(node).size(); i++){
            int adjnode = adj.get(node).get(i)[1];
            if(d[adjnode] < d[node])
                ans = (ans+DFS(adj , d , dp , adjnode))%mod;
        }
        dp[node] = (int)ans;
        return dp[node];
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][2] , edges[i][1]});
            adj.get(edges[i][1]).add(new int[]{edges[i][2] , edges[i][0]});
        }
        int[] d = new int[n+1];
        int[] ways = new int[n+1];
        Arrays.fill(d , Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{0 , n});
        d[n] = 0;
        ways[n] = 1;
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(distance+weight > distance && distance+weight < d[adjnode]){
                    d[adjnode] = distance+weight;
                    ways[adjnode] = ways[node];
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }else if(distance+weight > distance && distance+weight == d[adjnode]){
                    ways[adjnode] = (ways[adjnode]+ways[node])%mod;
                }
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return DFS(adj , d , dp , 1);
    }
}