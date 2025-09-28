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
    int floor(int[][] a , int x){
        int s = 0;
        int e = a.length-1;
        int f = -1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m][0] <= x){
                f = m;
                s = m+1;
            }else
            e = m-1;
        }
        return f;
    }
    int ceil(int[][] a , int x){
        int s = 0;
        int e = a.length-1;
        int c =-1;
        while(s <= e){
            int m = s+(e-s)/2;
            if(a[m][0] < x)
            s = m+1;
            else{
                c = m;
                e = m-1;
            }
        }
        return c;
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] a = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        DisjointSet ds = new DisjointSet(nums.length);
        for(int i = 0; i < nums.length; i++){
            int f = floor(a , nums[i]+limit);
            int c = ceil(a , nums[i]-limit);
            if(ds.findParent(a[f][1]) != ds.findParent(a[c][1])){
                for(int j = c; j < f; j++){
                    ds.unionSetRank(a[j][1] , a[j+1][1]);
                }
            }
        }
        HashMap<Integer , List<Integer>> mapi = new HashMap<>();
        HashMap<Integer , List<Integer>> mapv = new HashMap<>();
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            mapi.put(ds.findParent(i) , new ArrayList<>());
            mapv.put(ds.findParent(i) , new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            mapi.get(ds.findParent(i)).add(i);
            mapv.get(ds.findParent(i)).add(nums[i]);
        }
        for(Integer x : mapv.keySet()){
            Collections.sort(mapv.get(x));
        }
        for(Integer x : mapi.keySet()){
            for(int i = 0; i < mapi.get(x).size(); i++){
                ans[mapi.get(x).get(i)] = mapv.get(x).get(i);
            }
        }
        return ans;
    }
}