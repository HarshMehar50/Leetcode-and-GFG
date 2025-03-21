class Solution {
    /*long solveTab(int[] a , int[] b){
        long[][] dp = new long[a.length+1][b.length+1];
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                long include = dp[i-1][j-1]+((long)(a[i-1]*b[j-1]));
                long exclude = dp[i][j-1];
                if(j-1 < i)
                dp[i][j] = include;
                else
                dp[i][j] = Math.max(include , exclude);
            }
        }
        return dp[4][b.length];
    }*/
    long solve(int[] a , int[] b , int i , int j , long[][] dp){
        if(i == a.length)
        return 0;
        if(j >= b.length)
        return (long)(-1e12);
        if(dp[i][j] != -1)
        return dp[i][j];
        long include = (long)((long)a[i]*(long)b[j])+solve(a , b , i+1 , j+1 , dp);
        long exclude = solve(a , b , i , j+1 , dp);
        long ans = Math.max(include , exclude);
        dp[i][j] = ans;
        return dp[i][j];
    }
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[a.length+1][b.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        long ans = solve(a , b , 0 , 0 , dp);
       // long[][] dp1 = dp;
        return ans;
    }
}