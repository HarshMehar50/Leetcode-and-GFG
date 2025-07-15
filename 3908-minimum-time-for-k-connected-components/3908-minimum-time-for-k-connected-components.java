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
    boolean predicate(int n , int[][] edges , int k , int t){
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < edges.length; i++){
            if(edges[i][2] > t)
            ds.unionSetRank(edges[i][0] , edges[i][1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(ds.findParent(i));
        }
        if(set.size() >= k)
        return true;
        else
        return false;
    }
    public int minTime(int n, int[][] edges, int k) {
        int s = 0;
        int e = (int)1e9;
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(n , edges , k , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}