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
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        DisjointSet ds = new DisjointSet(source.length);
        for(int[] a : allowedSwaps){
            if(ds.findParent(a[0]) != ds.findParent(a[1]))
            ds.unionSetRank(a[0] , a[1]);
        }
        /*HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length; i++){
            map.put(ds.findParent(i) , new ArrayList<>());
        } 
        for(int i = 0; i < source.length; i++){
            map.get(ds.findParent(i)).add(i);
        }
        int ans = 0;
        for(Integer x : map.keySet()){
            Set<Integer> set = new HashSet<>();
            for(Integer y : map.get(x)){
                set.add(source[y]);
                set.add(target[y]);
            }
            int union = set.size();
            int intersection = (2*map.get(x).size())-union;
            ans += union-intersection;
        }
        return ans;*/
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length; i++){
            map.computeIfAbsent(ds.findParent(i) , k->new ArrayList<>()).add(i);
        }
        int ans = 0;
        for(List<Integer> l : map.values()){
            HashMap<Integer , Integer> f = new HashMap<>();
            for(Integer x : l){
                f.put(source[x] , f.getOrDefault(source[x] , 0)+1);
            }
            for(Integer x : l){
                int f1 = f.getOrDefault(target[x] , 0);
                if(f1 > 0){
                    f.put(target[x] , f.get(target[x])-1);
                    if(f.get(target[x]) == 0)
                    f.remove(target[x]);
                }else
                ans++;
            }
        }
        return ans;
    }
}