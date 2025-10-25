class SummaryRanges {
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
                /*parent[up] = vp;
                size[vp] = size[vp]+size[up];*/
                parent[Math.max(up , vp)] = Math.min(up , vp);
                size[Math.min(up , vp)] = size[up]+size[vp];
            }else{
                /*parent[vp] = up;
                size[up] = size[up]+size[vp];*/
                parent[Math.max(up , vp)] = Math.min(up , vp);
                size[Math.min(up , vp)] = size[up]+size[vp];
            }
        }
    }
    DisjointSet ds;
    boolean[] active;
    List<Integer> l;
    public SummaryRanges() {
        ds = new DisjointSet(10000);
        active = new boolean[10001];
        l = new ArrayList<>();
    }
    
    public void addNum(int value) {
        active[value] = true;
        l.add(value);
        if(value-1 >= 0 && active[value-1])
        ds.unionSetSize(value , value-1);
        if(value+1 <= 10000 && active[value+1])
        ds.unionSetSize(value , value+1);
    }
    
    public int[][] getIntervals() {
        Set<Integer> set = new HashSet<>();
        for(Integer x : l){
            set.add(ds.findParent(x));
        }
        int[][] ans = new int[set.size()][2];
        int i = 0;
        for(Integer x : set){
            ans[i][0] = x;
            ans[i][1] = x+ds.size[x]-1;
            i++;
        }
        Arrays.sort(ans , (x , y)->Integer.compare(x[0] , y[0]));
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */