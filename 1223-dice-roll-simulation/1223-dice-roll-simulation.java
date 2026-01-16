class Solution {
    final int mod = 1000000007;
    int solve(int n , int[] rollMax , int pc , int cr , int[][][] dp){
        if(n == 0)
        return 1;
        if(dp[n][pc+1][cr] != -1)
        return dp[n][pc+1][cr];
        int ans = 0;
        for(int i = 0; i < 6; i++){
            if(i != pc)
            ans = (ans+solve(n-1 , rollMax , i , 1 , dp))%mod;
            else{
                if(cr < rollMax[i])
                ans = (ans+solve(n-1 , rollMax , i , cr+1 , dp))%mod;
            }
        }
        dp[n][pc+1][cr] = ans%mod;
        return dp[n][pc+1][cr];
    }
    public int dieSimulator(int n, int[] rollMax) {
        int max = 0; 
        for(int i = 0; i < 6; i++){
            max = Math.max(max , rollMax[i]);
        }
        int[][][] dp = new int[n+1][7][max+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(n , rollMax , -1 , 0 , dp);
    }
}