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
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        boolean[] present = new boolean[max+1];
        for(int i = 0; i < nums.length; i++){
            present[nums[i]] = true;
        }
        DisjointSet ds = new DisjointSet(max);
        /*for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(gcd(nums[i] , nums[j]) > 1)
                ds.unionSetSize(nums[i] , nums[j]);
            }
        }*/
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 2; i <= max; i++){
            for(int j = i; j <= max; j += i){
                if(present[j]){
                    if(!map.containsKey(i))
                    map.put(i , new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        for(Integer x : map.keySet()){
            for(int i = 0; i < map.get(x).size()-1; i++){
                ds.unionSetSize(map.get(x).get(i) , map.get(x).get(i+1));
            }
        }
        int ans = 0;
        for(int i = 0; i <= max; i++){
            ans = Math.max(ans , ds.size[i]);
        }
        return ans;
    }
}