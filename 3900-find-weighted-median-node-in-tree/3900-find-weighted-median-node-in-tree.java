class Solution {
    void DFS(HashMap<Integer , List<int[]>> adj , int[][] ancestors , int[] depth , int node , int parent , long[] d){
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
            ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(int[] a : adj.get(node)){
            if(a[0] != parent){
                depth[a[0]] = depth[node]+1;
                d[a[0]] = d[node]+a[1];
                DFS(adj , ancestors , depth , a[0] , node , d);
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
    int getNode(int u , int v , int k , int lca , int[] depth , int[][] ancestors , HashMap<Integer , List<int[]>> adj){
        int d1 = depth[u]-depth[lca];
        if(k <= d1)
        return liftNode(adj , ancestors , u , k);
        else{
            int d2 = depth[v]-depth[lca];
            int rem = d2-k+d1;
            if(rem < 0)
            return -1;
            return liftNode(adj , ancestors , v , rem);
        }
    }
    public int[] findMedian(int n, int[][] edges, int[][] queries) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        int log = (int)(Math.log(n)/Math.log(2))+1;
        int[][] ancestors = new int[n][log];
        for(int i = 0; i < ancestors.length; i++){
            Arrays.fill(ancestors[i] , -1);
        }
        int[] depth = new int[n];
        long[] d = new long[n];
        DFS(adj , ancestors , depth , 0 , -1 , d);
        int[] ans = new int[queries.length];
        /*Arrays.fill(ans , -1); 
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == queries[i][1]) continue;
            int lca = LCA(adj , ancestors , depth , queries[i][0] , queries[i][1]);
            int dt = d[queries[i][0]]+d[queries[i][1]]-2*d[lca];
            int d0l = d[queries[i][0]]+d[lca]-2*d[LCA(adj , ancestors , depth , queries[i][0] , lca)];
            int dl1 = d[queries[i][1]]+d[lca]-2*d[LCA(adj , ancestors , depth , queries[i][1] , lca)];
            if(2*d0l >= dt){
                int li = 0;
                for(int j = 0; j < ancestors[0].length; j++){
                    if(ancestors[queries[i][0]][j] == lca){
                        li = j;
                        break;
                    }
                }
                for(int j = 0; j <= li; j++){
                    if(ancestors[queries[i][0]][j] != -1){
                        int db = d[queries[i][0]]+d[ancestors[queries[i][0]][j]]-2*d[LCA(adj , ancestors , depth , queries[i][0] , ancestors[queries[i][0]][j])];
                        if(db >= dt/2){
                            ans[i] = ancestors[queries[i][0]][j];
                            break;
                        }
                    }
                }
            }else{
                int li = 0;
                for(int j = 0; j < ancestors[0].length; j++){
                    if(ancestors[queries[i][1]][j] == lca){
                        li = j;
                        break;
                    }
                }
                for(int j = li; j >= 0; j--){
                    if(ancestors[queries[i][1]][j] != -1){
                        int db = d0l+d[lca]+d[ancestors[queries[i][1]][j]]-2*d[LCA(adj , ancestors , depth , lca , ancestors[queries[i][1]][j])];
                        if(db >= dt/2){
                            ans[i] = ancestors[queries[i][1]][j];
                            break;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == queries[i][1] || ans[i] == -1)
            ans[i] = queries[i][1];
        }
        return ans;*/
        for(int i = 0; i < queries.length; i++){
            int lca = LCA(adj , ancestors , depth , queries[i][0] , queries[i][1]);
            long td = d[queries[i][0]]+d[queries[i][1]]-2*d[lca];
            long median = (td+1)/2;
            int length = depth[queries[i][0]]+depth[queries[i][1]]-2*depth[lca];
            int s = 0;
            int medianNode = queries[i][1];
            int e = length;
            while(s <= e){
                int m = s+(e-s)/2;
                int midNode = getNode(queries[i][0] , queries[i][1] , m , lca , depth , ancestors , adj);
                if(midNode == -1)
                break;
                long weight = d[queries[i][0]]+d[midNode]-2*d[LCA(adj , ancestors , depth , queries[i][0] , midNode)];
                if(weight >= median){
                    medianNode = midNode;
                    e = m-1;
                }else
                s = m+1; 
            }
            ans[i] = medianNode;
        }
        return ans;
    }
}