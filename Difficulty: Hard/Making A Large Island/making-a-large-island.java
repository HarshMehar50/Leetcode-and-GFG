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

    public int largestIsland(int[][] grid) {
        // code here
        DisjointSet ds = new DisjointSet(grid.length*grid[0].length);
        int[] dR = {0 , 1 , 0 , -1};
        int[] dC = {1 , 0 , -1 , 0};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        int nr = i+dR[k];
                        int nc = j+dC[k];
                        if(nr < grid.length && nc < grid[0].length && nr >= 0 && nc >= 0 && grid[nr][nc] == 1)
                        ds.unionSetSize((i*grid[0].length)+j , (nr*grid[0].length)+nc);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                ans = Math.max(ans , ds.size[ds.findParent((i*grid[0].length)+j)]);
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int k = 0; k < 4; k++){
                        int nr = i+dR[k];
                        int nc = j+dC[k];
                        if(nr < grid.length && nc < grid[0].length && nr >= 0 && nc >= 0 && grid[nr][nc] == 1)
                        set.add(ds.findParent((nr*grid[0].length)+nc));
                    }
                    int ns = 1;
                    for(Integer x : set){
                        ns += ds.size[x];
                    }
                    ans = Math.max(ans , ns);
                }
            }
        }
        return ans;
    }
}
