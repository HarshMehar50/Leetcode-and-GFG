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
    public boolean gcdSort(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        boolean[] present = new boolean[max+1];
        for(int i = 0; i < nums.length; i++){
            present[nums[i]] = true;
        }
        DisjointSet ds = new DisjointSet(max);
        for(int gcd = 2; gcd <= max; gcd++){
            List<Integer> l = new ArrayList<>();
            for(int i = gcd; i <= max; i += gcd){
                if(present[i])
                l.add(i);
            }
            for(int i = 0; i < l.size()-1; i++){
                ds.unionSetSize(l.get(i) , l.get(i+1));
            }
        }
        /*Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(ds.size[ds.findParent(nums[i])]);
        }
        for(Integer x : set){
            if(x == 1)
            return false;
        }
        return true;*/
        /*DisjointSet ds = new DisjointSet(max);
        int[] spf = new int[max+1];
        for(int i = 2; i <= max; i++){
            if(spf[i] == 0){
                for(int j = i; j <= max; j += i){
                    if(spf[j] == 0)
                    spf[j] = i;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            while(x > 1){
                int p = spf[x];
                ds.unionSetRank(nums[i] , p);
                while(x%p == 0){
                    x = x/p;
                }
            }
        }*/
        int[] t = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            t[i] = nums[i];
        }
        Arrays.sort(t);
        for(int i = 0; i < nums.length; i++){
            if(ds.findParent(nums[i]) != ds.findParent(t[i]))
            return false;
        }
        return true;
    }
}