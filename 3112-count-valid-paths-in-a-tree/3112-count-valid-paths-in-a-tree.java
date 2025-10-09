class Solution {
    boolean[] seive(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        for(int i = 2; i <= n; i++){
            if(p[i] && (long)((long)i*(long)i) <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
            }
        }
        p[0] = false;
        p[1] = false;
        return p;
    }
    class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            size = new int[n+1];
            for(int i = 0; i <= n; i++){
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
    }
    public long countPaths(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        DisjointSet ds = new DisjointSet(n);
        boolean[] prime = seive(n);
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            if(!prime[edges[i][0]] && !prime[edges[i][1]])
            ds.unionSetSize(edges[i][0] , edges[i][1]);
        }
        
        long ans = 0;
        for(int i = 1; i <= n; i++){
            if(prime[i]){
                Set<Integer> sp = new HashSet<>();
                long ts = 0;
                for(Integer x : adj.get(i)){
                    if(!prime[x])
                    sp.add(ds.findParent(x));
                }
                for(Integer x : sp){
                    ans += ds.size[x];
                    ts += ds.size[x];
                }
                for(Integer x : sp){
                    ts -= ds.size[x];
                    ans += ts*(long)ds.size[x];
                }
            }
        }
        return ans;
    }
}