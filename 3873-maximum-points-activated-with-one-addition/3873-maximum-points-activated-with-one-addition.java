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
    public int maxActivated(int[][] points) {
        HashMap<Integer , List<Integer>> mapx = new HashMap<>();
        HashMap<Integer , List<Integer>> mapy = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            mapx.put(points[i][0] , new ArrayList<>());
            mapy.put(points[i][1] , new ArrayList<>());
        }
        for(int i = 0; i < points.length; i++){
            mapx.get(points[i][0]).add(i);
            mapy.get(points[i][1]).add(i);
        }
        DisjointSet ds = new DisjointSet(points.length);
        for(Integer x : mapx.keySet()){
            for(int i = 1; i < mapx.get(x).size(); i++){
                ds.unionSetSize(mapx.get(x).get(0) , mapx.get(x).get(i));
            }
        }
        for(Integer y : mapy.keySet()){
            for(int i = 1; i < mapy.get(y).size(); i++){
                ds.unionSetSize(mapy.get(y).get(0) , mapy.get(y).get(i));
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < points.length; i++){
            set.add(ds.findParent(i));
        }
        List<Integer> l = new ArrayList<>();
        for(Integer x : set){
            l.add(ds.size[x]);
        }
        Collections.sort(l);
        int ans = l.get(l.size()-1);
        if(l.size() >= 2)
        ans += l.get(l.size()-2);
        ans++;
        return ans;
    }
}