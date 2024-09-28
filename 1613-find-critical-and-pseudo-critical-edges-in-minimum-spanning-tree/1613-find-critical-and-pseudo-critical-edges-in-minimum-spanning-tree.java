class Solution {
    int N;
     class DisjointSet{
        int[] parent;
        int[] rank;
        public DisjointSet(int N){
            parent = new int[N];
            rank = new int[N];
            for(int i = 0; i < N; i++){
                parent[i] = i;
            }
        }
        int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        void unionSet(int u , int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            return;
            if(rank[up] > rank[vp]){
                parent[vp] = up;
            }else if(rank[up] < rank[vp]){
                parent[up] = vp;
            }else{
                parent[up] = vp;
                rank[vp]++;
            }
        }
    }
    int Kruskal(int[][] edges , int skip , int add){
        int minWeight = 0;
        DisjointSet ds = new DisjointSet(N);
        int edgeCount = 0;
        if(add != -1){
            ds.unionSet(edges[add][0] , edges[add][1]);
            minWeight += edges[add][2];
            edgeCount++;
        }
        for(int i = 0; i < edges.length; i++){
            if(i == skip) continue;
            int up = ds.findParent(edges[i][0]);
            int vp = ds.findParent(edges[i][1]);
            if(up != vp){
                ds.unionSet(edges[i][0] , edges[i][1]);
                minWeight += edges[i][2];
                edgeCount++;
            }
        }
        if(edgeCount != N-1)
        return Integer.MAX_VALUE;
        return minWeight;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        N = n;
        int[][] g = new int[edges.length][4];
        for(int i = 0; i < edges.length; i++){
            g[i][0] = edges[i][0];
            g[i][1] = edges[i][1];
            g[i][2] = edges[i][2];
            g[i][3] = i;
        }
        Arrays.sort(g , (x , y)->Integer.compare(x[2] , y[2]));
        int mst = Kruskal(g , -1 , -1);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for(int i = 0; i < g.length; i++){
            if(Kruskal(g , i , -1) > mst)
            critical.add(g[i][3]);
            else if(Kruskal(g , -1 , i) == mst)
            pseudoCritical.add(g[i][3]);
        }
        ans.add(critical);
        ans.add(pseudoCritical);
        return ans;
    }
}