class Solution {
    /*class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        void unionSetRank(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            return;
            if(rank[up] < rank[vp]){
                parent[up] = vp;
            }else if(rank[vp] < rank[up]){
                parent[vp] = up;
            }else{
                parent[up] = vp;
                rank[vp]++;
            }
        }
        void unionSetSize(int u , int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            return;
            if(size[up] < size[vp]){
                parent[up] = vp;
                size[vp] = size[vp]+size[up];
            }else{
                parent[vp] = up;
                size[up] = size[up]+size[vp];
            }
        }
    }*/
    void DFS(HashMap<Integer , List<int[]>> adj , boolean[] visited , int node , int m){
        visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i)[1] <= m && !visited[adj.get(node).get(i)[0]]){
                visited[adj.get(node).get(i)[0]] = true;
                DFS(adj , visited , adj.get(node).get(i)[0] , m);
            }
        }
    }
    boolean allVisited(int n , HashMap<Integer , List<int[]>> adj , int m){
        boolean[] visited = new boolean[n];
        DFS(adj , visited , 0 , m);
        for(int i = 0; i < visited.length; i++){
            if(!visited[i])
            return false;
        }
        return true;
    }
    int solve(int n , int[][] edges , int threshold){
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        Arrays.sort(edges , (x , y)->Integer.compare(x[2] , y[2]));
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        int e = edges[edges.length-1][2];
        int s = 0;
        int ans = Integer.MAX_VALUE;
        while(s <= e){
            int m = s+(e-s)/2;
            if(allVisited(n , adj , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        if(ans == Integer.MAX_VALUE)
        return -1;
        else
        return ans;
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        /*DisjointSet ds = new DisjointSet(n);
        Arrays.sort(edges , (x , y)->Integer.compare(x[2] , y[2]));
        int ans = 0;
        int[] outDegree = new int[n];
        int c = 0;
        for(int i = 0; i < edges.length; i++){
            if(ds.findParent(edges[i][0]) != ds.findParent(edges[i][1]) && ds.findParent(edges[i][1]) == 0 && outDegree[edges[i][0]] < threshold){
                ds.unionSetRank(edges[i][0] , edges[i][1]);
                outDegree[edges[i][0]]++;
                ans = edges[i][2];
            }
        }
        if(ans == edges[edges.length-1][2])
        return -1;
        else
        return ans;*/
        /*HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
        }
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(parent , -1);
        Arrays.fill(key , Integer.MAX_VALUE);
        key[0] = 0;
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int u = 0;
            for(int v = 0; v < n; v++){
                if(!mst[v] && key[v] < min){
                    u = v;
                    min = key[v];
                }
            }
            mst[u] = true;
            for(int j = 0; j < adj.get(u).size(); i++){
                int v = adj.get(u).get(j)[0];
                int w = adj.get(u).get(j)[1];
                if(!mst[v] && w < key[v]){
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(key[i] != Integer.MAX_VALUE)
            ans = Math.max(key[i] , ans);
        }
        return ans;*/
        return solve(n , edges , threshold);
    }
}