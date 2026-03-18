class Solution {
    final int mod = 1000000007;
    int solve(int target , int[][] types , int i , int[][] dp){
        if(i >= types.length){
            if(target == 0)
            return 1;
            else
            return 0;
        }
        if(dp[target][i] != -1)
        return dp[target][i];
        int ans = 0;
        for(int j = 0; j <= types[i][0]; j++){
            if(types[i][1]*j <= target)
            ans = (ans+solve(target-(j*types[i][1]) , types , i+1 , dp))%mod;
        }
        dp[target][i] = ans;
        return dp[target][i];
    }
    public int waysToReachTarget(int target, int[][] types) {
        int[][] dp = new int[target+1][types.length];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(target , types , 0 , dp);
    }
}