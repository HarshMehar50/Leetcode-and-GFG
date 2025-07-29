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
    public boolean canTraverseAllPairs(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        DisjointSet ds = new DisjointSet(max);
        /*for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1){
                for(int j = nums[i]; j <= max; j += nums[i]){
                    int bs = Arrays.binarySearch(nums , j);
                    if(bs < nums.length && bs >= 0)
                    ds.unionSetRank(j , nums[i]);
                }
            }
        }*/
        if(nums[0] == 1 && nums.length != 1)
            return false;
        for(int i = 2; i <= max; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = i; j <= max; j += i){
                int bs = Arrays.binarySearch(nums , j);
                if(bs < nums.length && bs >= 0)
                    l.add(j);
            }
            for(int j = 0; j < l.size()-1; j++){
                ds.unionSetRank(l.get(j) , l.get(j+1));
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(ds.findParent(nums[i]));
        }
        if(set.size() == 1)
            return true;
        else
            return false;
    }
}