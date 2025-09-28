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
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        DisjointSet ds = new DisjointSet(nums.length);
        for(int i = 0; i < swaps.length; i++){
            if(ds.findParent(swaps[i][0]) != ds.findParent(swaps[i][1]))
            ds.unionSetRank(swaps[i][0] , swaps[i][1]);
        }
        HashMap<Integer , List<int[]>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(ds.findParent(i) , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            map.get(ds.findParent(i)).add(new int[]{i , nums[i]});
        }
        long ans = 0;
        for(Integer x : map.keySet()){
            int c = 0;
            long s = 0;
            for(int[] a : map.get(x)){
                if(a[0]%2 == 0)
                c++;
                s += a[1];
            }
            Collections.sort(map.get(x) , (a , b)->Integer.compare(b[1] , a[1]));
            long se = 0;
            for(int i = 0; i < c; i++){
                se += map.get(x).get(i)[1];
            }
            ans += (2*se)-s;
        }
        return ans;
    }
}