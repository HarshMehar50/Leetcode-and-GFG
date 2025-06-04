class Solution {
    int[] DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        int md = 0;
        int farthest = node;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                int[] result = DFS(x , adj , visited);
                int d = result[0]+1;
                if(d > md){
                    md = d;
                    farthest = result[1];
                }
            }
        }
        return new int[]{md , farthest};
    }
    int daimeter(int n , HashMap<Integer , List<Integer>> adj){
        boolean[] visited = new boolean[n+1];
        int sn = adj.keySet().iterator().next();
        int[] f = DFS(sn , adj , visited);
        Arrays.fill(visited , false);
        int[] s = DFS(f[1] , adj , visited);
        return s[0];
    }
    void DFSC(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFSC(adj , visited , x);
        }
    }
    boolean valid(int n , HashMap<Integer , List<Integer>> adj){
        boolean[] visited = new boolean[n+1];
        int c = 0;
        for(Integer x : adj.keySet()){
            if(!visited[x]){
                c++;
                DFSC(adj , visited , x);
            }
        }
        if(c == 1)
        return true;
        else
        return false;
    }
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] ans = new int[n-1];
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int mask = 1; mask < (1<<edges.length); mask++){
            if(Integer.bitCount(mask) == 1)
            ans[0]++;
            else{
            for(int i = 1; i <= n; i++){
                adj.put(i , new ArrayList<>());
            }
            for(int i = 0; i < edges.length; i++){
                if((mask&(1<<i)) != 0){
                    adj.get(edges[i][0]).add(edges[i][1]);
                    adj.get(edges[i][1]).add(edges[i][0]);
                }
            }
            adj.entrySet().removeIf(entry -> entry.getValue().isEmpty());
            int d = 0;
            if(valid(n , adj))
            d = daimeter(n , adj);
            if(d-1 >= 0 && d-1 < n-1)
            ans[d-1]++;
            adj.clear();
            }
        }
        return ans;
    }
}