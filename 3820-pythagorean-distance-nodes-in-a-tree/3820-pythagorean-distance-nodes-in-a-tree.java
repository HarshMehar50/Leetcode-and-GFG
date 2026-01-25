class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , int[][] ancestors , int[] d){
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
                ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(Integer x : adj.get(node)){
            if(x != parent){
                d[x] = d[node]+1;
                DFS(adj , x , node , ancestors , d);
            }
        }
    }
    int lca(int u , int v , int[] d , int[][] ancestors){
        if(d[u] < d[v]){
            int t = u;
            u = v;
            v = t;
        }
        int d1 = d[u]-d[v];
        for(int j = 0; j < ancestors[0].length; j++){
            if(((d1>>j)&1) == 1)
                u = ancestors[u][j];
        }
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
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int log = (int)(Math.log(n)/Math.log(2))+1;
        int[][] ancestors = new int[n][log+1];
        for(int[] a : ancestors){
            Arrays.fill(a , -1);
        }
        int[] d = new int[n];
        DFS(adj , 0 , -1 , ancestors , d);
        int ans = 0;
        for(int i = 0; i < n; i++){
            int dx = d[x]+d[i]-2*d[lca(x , i , d , ancestors)]; 
            int dy = d[y]+d[i]-2*d[lca(y , i , d , ancestors)]; 
            int dz = d[z]+d[i]-2*d[lca(z , i , d , ancestors)]; 
            int[] a = {dx , dy , dz};
            Arrays.sort(a);
            if((a[0]*a[0])+(a[1]*a[1]) == (a[2]*a[2]))
                ans++;
        }
        return ans;
    }
}