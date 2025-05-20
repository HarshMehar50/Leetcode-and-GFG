class Solution {
    void DFS(HashMap<Integer , List<int[]>> adj , int[][] ancestors , int[] depth , int node , int parent){
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
            ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(int[] a : adj.get(node)){
            if(a[0] != parent){
                depth[a[0]] = depth[node]+1;
                DFS(adj , ancestors , depth , a[0] , node);
            }
        }
    }
    int liftNode(HashMap<Integer , List<int[]>> adj , int[][] ancestors , int node , int k){
        for(int i = 0; i < ancestors[0].length; i++){
            if((k&(1<<i)) > 0){
                node = ancestors[node][i];
                if(node == -1)
                break;
            }
        }
        return node;
    }
    int LCA(HashMap<Integer , List<int[]>> adj , int[][] ancestors , int[] depth , int u , int v){
        if(depth[u] < depth[v]){
            int temp = u;
            u = v;
            v = temp;
        }
        u = liftNode(adj , ancestors , u , depth[u]-depth[v]);
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
    void BFS(HashMap<Integer , List<int[]>> adj , int[][] f , int n , int s){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!visited[adj.get(node).get(i)[0]]){
                    q.offer(adj.get(node).get(i)[0]);
                    visited[adj.get(node).get(i)[0]] = true;
                    for(int j = 0; j < f[0].length; j++){
                        if(f[node][j] != 0)
                        f[adj.get(node).get(i)[0]][j] = f[node][j];
                    }
                    f[adj.get(node).get(i)[0]][adj.get(node).get(i)[1]]++;
                }
            }
        }
    }
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        int[][] ancestors = new int[n][(int)(Math.log(n)/Math.log(2))+1];
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
            Arrays.fill(ancestors[i] , -1);
        }
        int mw = 0;
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
            mw = Math.max(mw , edges[i][2]);
        }
        int[][] f = new int[n][mw+1];
        BFS(adj , f , n , 0);
        int[] depth = new int[n];
        DFS(adj , ancestors , depth , 0 , -1);
        int[] ans = new int[queries.length];
        Arrays.fill(ans , Integer.MAX_VALUE);
        int[] d = new int[n];
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= mw; j++){
                d[i] += f[i][j];
            }
        }
        for(int i = 0; i < ans.length; i++){
            int lca = LCA(adj , ancestors , depth , queries[i][0] , queries[i][1]);
            int ec = d[queries[i][0]]+d[queries[i][1]]-(2*d[lca]);
            for(int j = 1; j <= mw; j++){
                ans[i] = Math.min(ans[i] , ec-(f[queries[i][0]][j]+f[queries[i][1]][j]-(2*f[lca][j])));
            } 
            if(ans[i] == Integer.MAX_VALUE)
            ans[i] = 0; 
        }
        return ans;
    }
}