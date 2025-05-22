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
    void DFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
                DFS(adj , visited , x);
        }
    }
    public int minSwapsCouples(int[] row) {
        int[] ci = new int[row.length];
        for(int i = 0; i < row.length; i++){
            ci[row[i]] = i/2;
        }
        DisjointSet ds = new DisjointSet(row.length/2);
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < row.length/2; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < row.length; i++){
            if(row[i]%2 == 0){
                if(!adj.get(ci[row[i]]).contains(ci[row[i]+1])){
                    adj.get(ci[row[i]]).add(ci[row[i]+1]);
                    if(ds.findParent(ci[row[i]]) != ds.findParent(ci[row[i]+1]))
                        ds.unionSetRank(ci[row[i]] , ci[row[i]+1]);
                }
            }else{
                if(!adj.get(ci[row[i]]).contains(ci[row[i]-1])){
                    adj.get(ci[row[i]]).add(ci[row[i]-1]);
                    if(ds.findParent(ci[row[i]]) != ds.findParent(ci[row[i]-1]))
                        ds.unionSetRank(ci[row[i]] , ci[row[i]-1]);
                }
            }
        }
        /*int c = 0;
        boolean[] visited = new boolean[row.length/2];
        for(int i = 0; i < row.length/2; i++){
            if(!visited[i]){
                c++;
                DFS(adj , visited , i);
            }
        }*/
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < row.length/2; i++){
            set.add(ds.findParent(i));
        }
        return (row.length/2)-set.size();
    }
}