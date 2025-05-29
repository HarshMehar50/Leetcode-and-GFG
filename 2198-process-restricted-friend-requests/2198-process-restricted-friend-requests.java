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
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < restrictions.length; i++){
            map.put(restrictions[i][0] , restrictions[i][1]);
            map.put(restrictions[i][1] , restrictions[i][0]);
        }
        boolean[] ans = new boolean[requests.length];
        Arrays.fill(ans , true);
        for(int i = 0; i < requests.length; i++){
            int p1 = ds.findParent(requests[i][0]);
            int p2 = ds.findParent(requests[i][1]);
            for(int j = 0; j < restrictions.length; j++){
                int rp1 = ds.findParent(restrictions[j][0]);
                int rp2 = ds.findParent(restrictions[j][1]);
                if((rp1 == p1 && rp2 == p2)||(rp1 == p2 && rp2 == p1)){
                    ans[i] = false;
                    break;
                }
            }
            if(ans[i])
                ds.unionSetRank(requests[i][0] , requests[i][1]);
        }
        return ans;
    }
}