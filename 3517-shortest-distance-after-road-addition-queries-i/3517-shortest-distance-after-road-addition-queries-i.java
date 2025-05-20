class Solution {
    int BFS(HashMap<Integer , List<Integer>> adj , int s , int des){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , s});
        int[] d = new int[adj.size()];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[s] = 0;
        while(!q.isEmpty()){
            int distance = q.peek()[0];
            int node = q.peek()[1];
            q.poll();
            if(des == node)
                return distance;
            for(int i = 0; i < adj.get(node).size(); i++){
                int adjnode = adj.get(node).get(i);
                if(distance+1 < d[adjnode]){
                    d[adjnode] = distance+1;
                    q.offer(new int[]{d[adjnode] , adjnode});
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
            int c = BFS(adj , 0 , n-1);
            ans[i] = c;
        }
        return ans;
    }
}