class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        List<TreeSet<Integer>> list;
        boolean[] active;
        public DisjointSet(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            size = new int[n+1];
            list = new ArrayList<>();
            active = new boolean[n+1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
                size[i] = 1;
                list.add(new TreeSet<>());
                    if(i != 0)
                    list.get(i).add(i);
                active[i] = true;
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
                list.get(vp).addAll(list.get(up));
            }else if(rank[vp] < rank[up]){
                parent[vp] = up;
                list.get(up).addAll(list.get(vp));
                list.get(vp).clear();
            } else {
                 parent[up] = vp;
                rank[vp]++;
                list.get(vp).addAll(list.get(up));
                 list.get(up).clear();
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
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(c);
        for(int i = 0; i < connections.length; i++){
            ds.unionSetRank(connections[i][0] , connections[i][1]);
            /*ds.active[connections[i][0]] = true;
            ds.active[connections[i][1]] = true;*/
        }
        for(int i = 0; i < queries.length; i++){
            if(queries[i][0] == 1){
                if(ds.active[queries[i][1]])
                    ans.add(queries[i][1]);
                else{
                    int p = ds.findParent(queries[i][1]);
                    if(ds.list.get(p).isEmpty())
                        ans.add(-1);
                    else
                        ans.add(ds.list.get(p).first());
                }
            }else if(queries[i][0] == 2){
                if(ds.active[queries[i][1]]){
                    ds.active[queries[i][1]] = false;
                    ds.list.get(ds.findParent(queries[i][1])).remove(queries[i][1]);
                }
            }
        }
        int[] fans = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            fans[i] = ans.get(i);
        }
        return fans;
    }
}