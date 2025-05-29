class Solution {
    final int mod = 1000000007;
    void DFS(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int[] depth , int node , int parent){
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
            ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(Integer x : adj.get(node)){
            if(x != parent){
                depth[x] = depth[node]+1;
                DFS(adj , ancestors , depth , x , node);
            }
        }
    }
    int liftNode(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int[] depth , int node , int k){
        for(int i = 0; i < ancestors[0].length; i++){
            if((k&(1<<i)) > 0){
                node = ancestors[node][i];
                if(node == -1)
                break;
            }
        }
        return node;
    }
    int LCA(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int[] depth , int u , int v){
        if(depth[u] < depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }
        u = liftNode(adj , ancestors , depth , u , depth[u]-depth[v]);
        if(u == v)
        return u;
        for(int i = ancestors[0].length-1; i >= 0; i--){
            if(ancestors[u][i] != ancestors[v][i]){
                u = ancestors[u][i];
                v = ancestors[v][i];
            }
        }
        return ancestors[u][0];
    }
    int modPow(int base, int exp, int mod) {
    long result = 1;
    long b = base;
    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * b) % mod;
        }
        b = (b * b) % mod;
        exp >>= 1;
    }
    return (int) result;
    }
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= edges.length+1; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[][] ancestors = new int[edges.length+2][(int)(Math.log(edges.length+1)/Math.log(2))+1];
        int[] depth = new int[edges.length+2];
        for(int i = 0; i < ancestors.length; i++){
            Arrays.fill(ancestors[i] , -1);
        }
        DFS(adj , ancestors , depth , 1 , 0);
        int[] ans = new int[queries.length];
        Arrays.fill(ans , 1);
        for(int i = 0; i < ans.length; i++){
            if(queries[i][0] == queries[i][1])
            ans[i] = 0;
            else{
                int l = depth[queries[i][0]]+depth[queries[i][1]]-(2*depth[LCA(adj , ancestors , depth , queries[i][0] , queries[i][1])]);
                ans[i] = modPow(2, l - 1, mod);
            }
        }
        return ans;
    }
}