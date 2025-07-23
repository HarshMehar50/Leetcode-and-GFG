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
    public int numberOfComponents(int[][] properties, int k) {
        DisjointSet ds = new DisjointSet(properties.length);
        Set<Integer>[] sa = new HashSet[properties.length];
        for(int i = 0; i < sa.length; i++){
            sa[i] = new HashSet<>();
        }
        for(int i = 0; i < properties.length; i++){
            for(int j = 0; j < properties[0].length; j++){
                sa[i].add(properties[i][j]);
            }
        }
        for(int i = 0; i < sa.length; i++){
            for(int j = i+1; j < sa.length; j++){
                Set<Integer> set = new HashSet<>();
                set.addAll(sa[i]);
                set.addAll(sa[j]);
                if(set.size() <= sa[i].size()+sa[j].size()-k)
                ds.unionSetRank(i , j);
            }
        } 
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < properties.length; i++){
            set.add(ds.findParent(i));
        }
        return set.size();
    }
}