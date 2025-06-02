class Solution {
    int BFS(HashMap<Integer , List<Integer>> adj , int n , int s){
        int[] d = new int[n];
        int ans = Integer.MAX_VALUE;
        Arrays.fill(d , Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        d[s] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                if(d[adj.get(node).get(i)] == Integer.MAX_VALUE){
                    q.offer(adj.get(node).get(i));
                    d[adj.get(node).get(i)] = d[node]+1;
                }else if(d[adj.get(node).get(i)] >= d[node]){
                    ans = Math.min(ans , d[node]+d[adj.get(node).get(i)]+1);
                }
            }
        }
        return ans+1;
    }
    public int findShortestCycle(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans , BFS(adj , n , i));
        }
        if(ans != Integer.MAX_VALUE)
            return ans;
        else return -1;
    }
}