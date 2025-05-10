class Solution {
    int solve(HashMap<Integer , List<int[]>> adj , int node , int k , int t , int s , int[][][] dp){
        if(k == 0){
            if(t > s)
            return s;
            else
            return Integer.MIN_VALUE;
        }
        if(t > s && dp[node][k][s] != -1)
        return dp[node][k][s];
        int ans = Integer.MIN_VALUE;
        for(int[] a : adj.get(node)){
            ans = Math.max(ans , solve(adj , a[0] , k-1 , t , s+a[1] , dp));
        }
        if(t > s)
        dp[node][k][s] = ans;
        if(t > s)
        return dp[node][k][s];
        else
        return Integer.MIN_VALUE;
    }
    public int maxWeight(int n, int[][] edges, int k, int t) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
        }
        int ans = Integer.MIN_VALUE;
        int[][][] dp = new int[n][k+1][t+1];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        for(int i = 0; i < n; i++){
            if(dp[i][k][0] == -1)
            ans = Math.max(ans , solve(adj , i , k , t , 0 , dp));
            else
            ans = Math.max(ans , dp[i][k][0]);
        }
        if(ans != Integer.MIN_VALUE)
        return ans;
        else
        return -1;
    }
}