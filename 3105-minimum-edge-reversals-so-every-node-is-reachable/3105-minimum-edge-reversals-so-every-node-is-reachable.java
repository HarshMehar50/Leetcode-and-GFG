class Solution {
    int DFS(HashMap<Integer , List<int[]>> adj , int node , int parent){
        int ans = 0;
        for(int[] a : adj.get(node)){
            if(a[0] != parent)
            ans += 1-a[1]+DFS(adj , a[0] , node);
        }
        return ans;
    }
    void DFS(HashMap<Integer , List<int[]>> adj , int node , int parent , int[] dp){
        for(int[] a : adj.get(node)){
            if(a[0] != parent){
                if(a[1] == 1)
                dp[a[0]] = dp[node]+1;
                else
                dp[a[0]] = dp[node]-1;
                DFS(adj , a[0] , node , dp);
            }
        }
    }
    public int[] minEdgeReversals(int n, int[][] edges) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , 1});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , 0});
        }
        int rev0 = DFS(adj , 0 , -1);
        int[] ans = new int[n];
        ans[0] = rev0;
        DFS(adj , 0 , -1 , ans);
        return ans;
    }
}