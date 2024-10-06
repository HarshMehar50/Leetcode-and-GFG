class Solution {
    final int mod = 1000000007;
    public int valueAfterKSeconds(int n, int k) {
        int[][] dp = new int[k+1][n];
        Arrays.fill(dp[0] , 1);
        for(int i = 1; i <= k; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= k; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = (dp[i-1][j]+dp[i][j-1])%mod;
            }
        }
        return dp[k][n-1]%mod;
    }
}