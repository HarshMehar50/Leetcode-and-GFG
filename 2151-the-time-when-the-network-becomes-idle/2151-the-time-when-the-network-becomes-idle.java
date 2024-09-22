class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
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
                int adjnode = adj.get(node).get(i);
                if(1+distance < d[adjnode]){
                    d[adjnode] = 1+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            int t = 2*d[i];
            int nmessages = t/patience[i];
            if(t%patience[i] == 0)
            nmessages--;
            int lastmessage = nmessages*patience[i];
            ans = Math.max(ans , lastmessage+t+1);
        }
        return ans;
    }
}