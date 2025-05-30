class Solution {
    int find(int x , int[] parent){
        if(parent[x] == x)
        return x;
        return parent[x] = find(parent[x] , parent);
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost , -1);
        int[] ans = new int[query.length];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int pu = find(edges[i][0] , parent);
            int pv = find(edges[i][1] , parent);
            if(pu != pv){
                cost[pu] = cost[pu]&cost[pv];
                parent[pv] = pu;
            }
            cost[pu] = cost[pu]&edges[i][2];
        }
        for(int i = 0; i < ans.length; i++){
            int p1 = find(query[i][0] , parent);
            int p2 = find(query[i][1] , parent);
            if(query[i][0] == query[i][1])
            ans[i] = 0;
            else if(p1 != p2)
            ans[i] = -1;
            else
            ans[i] = cost[p1];
        }
        return ans;
    }
}