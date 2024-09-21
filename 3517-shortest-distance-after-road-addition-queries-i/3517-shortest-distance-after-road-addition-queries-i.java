class Solution {
    int BFS(HashMap<Integer , List<Integer>> adj , int des , int s){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[adj.size()];
        Arrays.fill(d , Integer.MAX_VALUE);
        pq.offer(new int[]{0 , s});
        d[s] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            if(node == des)
            return distance;
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = 1;
                int adjnode = adj.get(node).get(i);
                if(distance+weight < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return 0;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            adj.get(i).add(i+1);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            adj.get(queries[i][0]).add(queries[i][1]);
            int c = BFS(adj , n-1 , 0);
            ans[i] = c;
        }
        return ans;
    }
}