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
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        DisjointSet ds = new DisjointSet(vals.length);
        //Arrays.sort(vals);
        int ans = 0;
        TreeMap<Integer , List<Integer>> group = new TreeMap<>();
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < vals.length; i++){
            group.put(vals[i] , new ArrayList<>());
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < vals.length; i++){
            group.get(vals[i]).add(i);
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(Integer x : group.keySet()){
            for(Integer y : group.get(x)){
                for(Integer z : adj.get(y)){
                    if(vals[z] <= x)
                    ds.unionSetSize(y , z);
                }
            }
            /*for(int i = 0; i < group.get(x).size()-1; i++){
                for(int j = i+1; j < group.get(x).size(); j++){
                    if(ds.findParent(group.get(x).get(i)) == ds.findParent(group.get(x).get(j)))
                    ans++;
                }
            }*/
            Set<Integer> set = new HashSet<>();
            for(Integer y : group.get(x)){
                set.add(ds.findParent(y));
            }
            for(Integer y : set){
                ans += (ds.size[y]*(ds.size[y]-1))/2;
            }
        }
        /*boolean[] active = new boolean[vals.length];
        for(Integer x : group.keySet()){
            for(Integer y : group.get(x)){
                active[y] = true;
            }
            for(int i = 0; i < edges.length; i++){
                if(active[edges[i][0]] && active[edges[i][1]])
                ds.unionSetRank(edges[i][0] , edges[i][1]);
            }
            System.out.println(Arrays.toString(ds.parent));
            for(int i = 0; i < group.get(x).size()-1; i++){
                for(int j = i+1; j < group.get(x).size(); j++){
                    if(ds.findParent(group.get(x).get(i)) == ds.findParent(group.get(x).get(j)))
                    ans++;
                }
            }
        }*/
        return ans+vals.length;
    }
}