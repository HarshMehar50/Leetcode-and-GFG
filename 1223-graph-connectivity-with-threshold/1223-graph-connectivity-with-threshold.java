class Solution {
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
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i = threshold+1; i <= n; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = i; j <= n; j += i){
                l.add(j);
            }
            for(int j = 0; j < l.size()-1; j++){
                ds.unionSetRank(l.get(j) , l.get(j+1));
            }
        }
        for(int i = 0; i < queries.length; i++){
            if(ds.findParent(queries[i][0]) == ds.findParent(queries[i][1]))
            ans.add(true);
            else
            ans.add(false);
        }
        return ans;
    }
}