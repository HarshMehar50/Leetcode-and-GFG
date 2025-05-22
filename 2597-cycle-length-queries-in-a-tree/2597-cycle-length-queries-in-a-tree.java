class Solution {
    /*void DFS(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int[] depth , int node , int parent){
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
    int liftNode(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int node , int k){
        for(int i = 0; i < ancestors[0].length; i++){
            if((k&(1<<i)) > 0)
            node = ancestors[node][i];
            if(node == 0)
            break;
        }
        return node;
    }
    int LCA(HashMap<Integer , List<Integer>> adj , int[][] ancestors , int[] depth , int u , int v){
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
    }*/
    /*int[] BFS(HashMap<Integer , List<Integer>> adj){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()+1];
        int[] d = new int[adj.size()+1];
        q.offer(new int[]{1 , 0});
        visited[1] = true;
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int distance = q.peek()[1];
            d[node] = distance;
            q.poll();
            for(Integer x : adj.get(node)){
                if(!visited[x]){
                    q.offer(new int[]{x , distance+1});
                    visited[x] = true;
                }
            }
        }
        return d;
    }*/
    /*int LCA(int u , int v){
        int du = (int)(Math.log(u)/Math.log(2));
        int dv = (int)(Math.log(v)/Math.log(2));
        if(du < dv){
            int temp = u;
            u = v;
            v = temp;
        }
        u = u>>(du-dv);
        if(u == v)
        return u;
        int l = 0;
        int r = 31;
        while(l < r){
            int m = (l+r+1)/2;
            int nu = u>>m;
            int nv = v>>m;
            if(nu == nv)
            r = m-1;
            else
            l = m;
        }
        u = u>>l;
        return u>>1;
    }*/
    int LCA(int u, int v) {
    while (u != v) {
        if (u > v) {
            u = u / 2;
        } else {
            v = v / 2;
        }
    }
    return u;
}
    public int[] cycleLengthQueries(int n, int[][] queries) {
        /*HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= (1<<n)-1; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 1; i <= (1<<n)-1; i++){
            if(2*i <= (1<<n)-1){
                adj.get(i).add(2*i);
                adj.get(2*i).add(i);
            }
            if(2*i + 1 <= (1<<n)-1){
                adj.get(i).add((2*i)+1);
                adj.get((2*i)+1).add(i);
            }
        }
        int[][] ancestors = new int[(1<<n)][(int)(Math.log((1<<n)-1)/Math.log(2))+1];
        int[] depth = new int[(1<<n)];
        for(int i = 0; i < ancestors.length; i++){
            Arrays.fill(ancestors[i] , -1);
        }
        DFS(adj , ancestors , depth , 1 , 0);
        //int[] d = BFS(adj);
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            int lca = LCA(adj , ancestors , depth , queries[i][0] , queries[i][1]);
            //int d0 = d[queries[i][0]]+d[lca]-(2*d[LCA(adj , ancestors , depth , queries[i][0] , lca)]);
            //int d1 = d[queries[i][1]]+d[lca]-(2*d[LCA(adj , ancestors , depth , queries[i][1] , lca)]);
            ans[i] = depth[queries[i][0]]+depth[queries[i][1]]-(2*depth[lca])+1;
        }
        return ans;*/
        int[] ans = new int[queries.length];
        //int[] depth = new int[(1<<n)];
        /*for(int i = 1; i < (1<<n); i++){
            depth[i] = (int)(Math.log(i)/Math.log(2));
        }*/
        for(int i = 0; i < queries.length; i++){
            int lca = LCA(queries[i][0] , queries[i][1]);
            int d0 = (int)(Math.log(queries[i][0])/Math.log(2));
            int d1 = (int)(Math.log(queries[i][1])/Math.log(2));
            int dlca = (int)(Math.log(lca)/Math.log(2));
            ans[i] = d0+d1-(2*dlca)+1;
        }
        return ans;
    }
}