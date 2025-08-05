class Solution {
    class DisjointSet{
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
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < edges.length; i++){
            ds.unionSetRank(edges[i][0] , edges[i][1]);
        }
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(ds.findParent(i) , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            map.get(ds.findParent(edges[i][0])).add(edges[i][2]);
        }
        int[] cand = new int[n];
        for(Integer x : map.keySet()){
            if(map.get(x).size() > 0){
            int compand = map.get(x).get(0);
            for(Integer y : map.get(x)){
                compand = compand&y;
            }
            cand[x] = compand;
            }
        }
        int[] ans = new int[query.length];
        for(int i = 0; i < ans.length; i++){
            if(query[i][0] == query[i][1])
            ans[i] = 0;
            else if(ds.findParent(query[i][0]) != ds.findParent(query[i][1]))
            ans[i] = -1;
            else
            ans[i] = cand[ds.findParent(query[i][0])];
        }
        return ans;
    }
}