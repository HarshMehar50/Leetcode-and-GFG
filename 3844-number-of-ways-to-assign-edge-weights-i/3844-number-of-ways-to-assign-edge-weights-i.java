class Solution {
    final int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= edges.length+1; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[adj.size()+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int level = 0;
        visited[1] = true;
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                int node = q.poll();
                for(Integer x : adj.get(node)){
                    if(!visited[x]){
                        q.offer(x);
                        visited[x] = true;
                    }
                }
            }
            level++;
        }
        level--;
        int ans = 1;
        for(int i = 0; i < level-1; i++){
            ans = (ans*2)%mod;
        }
        return ans;
    }
}