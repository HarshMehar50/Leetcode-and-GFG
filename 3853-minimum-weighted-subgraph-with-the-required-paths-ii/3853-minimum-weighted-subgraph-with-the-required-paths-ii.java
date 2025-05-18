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
    int liftNode(HashMap<Integer , List<int[]>> adj , int[][] ancestors , int[] depth , int node , int k){
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
    int[] BFS(HashMap<Integer , List<int[]>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[adj.size()];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[0] = 0;
        pq.offer(new int[]{0 , 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            for(int[] a : adj.get(node)){
                int adjnode = a[0];
                int weight = a[1];
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d;
    }
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int max = (int)(Math.log(edges.length+1)/Math.log(2))+1;
        int[][] ancestors = new int[edges.length+1][max];
        for(int i = 0; i < ancestors.length; i++){
            Arrays.fill(ancestors[i] , -1);
        }
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i <= edges.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        int[] depth = new int[edges.length+1];
        depth[0] = 0;
        DFS(adj , ancestors , depth , 0 , -1);
        int[] d = BFS(adj);
        int[] ans = new int[queries.length];
        for(int i = 0; i < ans.length; i++){
            int s1 = queries[i][0];
            int s2 = queries[i][1];
            int des = queries[i][2];
            int ds1des = d[s1]+d[des]-2*d[LCA(adj , ancestors , depth , s1 , des)];
            int ds2des = d[s2]+d[des]-2*d[LCA(adj , ancestors , depth , s2 , des)];
            int ds1s2 = d[s1]+d[s2]-2*d[LCA(adj , ancestors , depth , s1 , s2)];
            ans[i] = (ds1des+ds2des+ds1s2)/2;
        }
        return ans;
    }
}