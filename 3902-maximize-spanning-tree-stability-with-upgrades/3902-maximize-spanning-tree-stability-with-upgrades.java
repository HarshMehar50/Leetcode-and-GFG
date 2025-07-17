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
    boolean predicate(int n , int[][] edges , int k , int m){
        /*DisjointSet ds = new DisjointSet(n);
        boolean[] mark = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(edges[i][3] == 1 && ds.findParent(edges[i][0]) != ds.findParent(edges[i][1]) && edges[i][2] >= m){
                ds.unionSetRank(edges[i][0] , edges[i][1]);
                mark[i] = true;
            }
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][3] == 1 && !mark[i])
            return false;
        }
        for(int i = 0; i < edges.length && k > 0; i++){
            if(edges[i][3] == 0 && 2*edges[i][2] >= m && ds.findParent(edges[i][0]) != ds.findParent(edges[i][1])){
                ds.unionSetRank(edges[i][0] , edges[i][1]);
                k--;
                mark[i] = true;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(ds.findParent(i));
        }
        if(set.size() != 1){
            for(int i = 0; i < edges.length; i++){
                if(!mark[i] && ds.findParent(edges[i][0]) != ds.findParent(edges[i][1]) && edges[i][2] >= m)
                ds.unionSetRank(edges[i][0] , edges[i][1]);
            }
        }
        Set<Integer> nset = new HashSet<>();
        for(int i = 0; i < n; i++){
            nset.add(ds.findParent(i));
        }
        if(nset.size() == 1)
        return true;
        else
        return false;*/
        DisjointSet ds = new DisjointSet(n);
        boolean[] mark = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            if(edges[i][3] == 1 && ds.findParent(edges[i][0]) != ds.findParent(edges[i][1]) && edges[i][2] >= m){
                ds.unionSetRank(edges[i][0] , edges[i][1]);
                mark[i] = true;
            }
        } 
        for(int i = 0; i < edges.length; i++){
            if(edges[i][3] == 1 && !mark[i])
            return false;
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i][3] == 0 && ds.findParent(edges[i][0]) != ds.findParent(edges[i][1])){
                if(edges[i][2] >= m){
                    ds.unionSetRank(edges[i][0] , edges[i][1]);
                    mark[i] = true;
                }else{
                    if(k > 0 && 2*edges[i][2] >= m){
                        ds.unionSetRank(edges[i][0] , edges[i][1]);
                        k--;
                        mark[i] = true;
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(ds.findParent(i));
        }
        if(set.size() == 1)
        return true;
        else
        return false;
    }
    public int maxStability(int n, int[][] edges, int k) {
        int s = 0;
        int e = 0;
        for(int i = 0; i < edges.length; i++){
            e = Math.max(e , edges[i][2]);
        }
        e = 2*e;
        Arrays.sort(edges , (x , y)->Integer.compare(y[2] , x[2]));
        int ans = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(predicate(n , edges , k , m)){
                ans = m;
                s = m+1;
            }else
            e = m-1;
        }
        return ans;
    }
}