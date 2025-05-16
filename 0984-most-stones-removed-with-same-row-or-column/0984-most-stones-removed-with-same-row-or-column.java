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
    public int removeStones(int[][] stones) {
        int maxr = 0;
        int maxc = 0;
        for(int i = 0; i < stones.length; i++){
            maxr = Math.max(maxr , stones[i][0]);
            maxc = Math.max(maxc , stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxr+maxc+1);
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++){
            int r = stones[i][0];
            int c = stones[i][1]+maxr+1;
            ds.unionSetSize(r , c);
            map.put(r , 1);
            map.put(c , 1);
        }
        int count = 0;
        for(Map.Entry<Integer , Integer> m : map.entrySet()){
            if(ds.findParent(m.getKey()) == m.getKey())
                count++;
        }
        return stones.length-count;
    }
}