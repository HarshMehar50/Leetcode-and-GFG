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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList , (x , y)->Integer.compare(x[2] , y[2]));
        int[][] q = new int[queries.length][4];
        for(int i = 0; i < queries.length; i++){
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = queries[i][2];
            q[i][3] = i;
        }
        Arrays.sort(q , (x , y)->Integer.compare(x[2] , y[2]));
        boolean[] ans = new boolean[queries.length];
        DisjointSet ds = new DisjointSet(n);
        int j = 0;
        for(int i = 0; i < queries.length; i++){
            while(j < edgeList.length && edgeList[j][2] < q[i][2]){
                ds.unionSetRank(edgeList[j][0] , edgeList[j][1]);
                j++;
            }
            if(ds.findParent(q[i][0]) == ds.findParent(q[i][1]))
                ans[q[i][3]] = true;
            else
                ans[q[i][3]] = false;
        }
        return ans;
    }
}