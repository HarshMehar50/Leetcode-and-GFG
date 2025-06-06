class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i < n+1; i++){
            dp[i] = 0;
        }
        dp[0] = dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}