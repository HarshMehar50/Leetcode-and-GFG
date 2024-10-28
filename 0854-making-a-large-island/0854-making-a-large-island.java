class Solution {
    class DisjointSet{
        int[] parent;
        int[] rank;
        int[] size;
        public DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            rank = new int[n];
            Arrays.fill(size , 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int findParent(int node){
            if(node == parent[node])
            return node;
            return parent[node] = findParent(parent[node]);
        }
        void unionRank(int u , int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv)
            return;
            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else if(rank[pv] < rank[pu]){
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
        void unionSize(int u , int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv) 
            return;
            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] = size[pv]+size[pu];
            }else{
                parent[pv] = pu;
                size[pu] = size[pu]+size[pv];
            }
        }
    }
    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length*grid[0].length);
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                for(int k = 0; k < 4; k++){
                    int nr = i+dR[k];
                    int nc = j+dC[k];
                    if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1)
                    ds.unionSize(i*grid.length + j , nr*grid.length + nc);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> comp = new HashSet<>();
                for(int k = 0; k < 4; k++){
                    int nr = i+dR[k];
                    int nc = j+dC[k];
                    if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0 && grid[nr][nc] == 1)
                    comp.add(ds.findParent(nr*grid.length + nc));
                }
                int sizeTotal = 0;
                for(Integer x : comp){
                 sizeTotal += ds.size[x];
                }
                max = Math.max(max , sizeTotal+1);
            }
        }
        for(int i = 0; i < grid.length*grid[0].length; i++){
            max = Math.max(max , ds.size[ds.findParent(i)]);
        }
        return max;
    }
}