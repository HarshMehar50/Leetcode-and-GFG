class Solution {
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
        return ans;
    }
}