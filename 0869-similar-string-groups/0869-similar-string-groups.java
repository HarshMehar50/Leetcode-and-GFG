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
    public int numSimilarGroups(String[] strs) {
        DisjointSet ds = new DisjointSet(strs.length);
        for(int i = 0; i < strs.length; i++){
            for(int j = i+1; j < strs.length; j++){
                if(strs[i].length() != strs[j].length()) continue;
                List<Integer> l = new ArrayList<>();
                for(int k = 0; k < strs[i].length(); k++){
                    if(strs[i].charAt(k) != strs[j].charAt(k))
                    l.add(k);
                }
                if(l.size() == 2 && strs[i].charAt(l.get(0)) == strs[j].charAt(l.get(1)) && strs[j].charAt(l.get(0)) == strs[i].charAt(l.get(1)))
                ds.unionSetRank(i , j);
                if(l.size() == 0)
                ds.unionSetRank(i , j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < strs.length; i++){
            set.add(ds.findParent(i));
        }
        return set.size();
    }
}