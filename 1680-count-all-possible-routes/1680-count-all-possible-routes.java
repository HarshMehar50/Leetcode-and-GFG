class Solution {
    final int mod = 1000000007;
    int solve(int[] locations , int node , int finish , int fuel , int[][] dp){
        if(fuel < 0)
        return 0;
        /*if(node == finish)
        return 1;*/
        if(dp[node][fuel] != -1)
        return dp[node][fuel];
        int ans = 0;
        if(node == finish)
        ans++;
        for(int i = 0; i < locations.length; i++){
            if(node != i){
                //if(fuel-Math.abs(locations[i]-locations[node]) >= 0)
                ans = (ans+solve(locations , i , finish , fuel-Math.abs(locations[i]-locations[node]) , dp))%mod;
            }
        }
        dp[node][fuel] = ans;
        return dp[node][fuel];
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp = new int[locations.length][fuel+1];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(locations , start , finish , fuel , dp);
    }
}