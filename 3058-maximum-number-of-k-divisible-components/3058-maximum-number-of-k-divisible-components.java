class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int[] values , int node , int parent , int k , int[] a , long[] subtree){
        subtree[node] = values[node];
        for(Integer x : adj.get(node)){
            if(x != parent){
                DFS(adj , values , x , node , k , a , subtree);
                subtree[node] += subtree[x];
            }
        }
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        long[] subtree = new long[n];
        int[] a = {0};
        DFS(adj , values , 0 , -1 , k , a , subtree);
        for(int i = 0; i < n; i++){
            if(subtree[i]%k == 0)
            a[0]++;
        }
        return a[0];
    }
}