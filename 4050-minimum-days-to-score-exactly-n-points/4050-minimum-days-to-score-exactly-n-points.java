class Solution {
    int solve(int n , int[] dp){
        if(n == 0)
        return 0;
        if(dp[n] != -1)
        return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i*(i+1)/2 <= n; i++){
            //int c = i;
            //if(n-(i*(i+1)/2) != 0)
            //c++;
            ans = Math.min(ans , i+1+solve(n-(i*(i+1)/2) , dp));
        }
        dp[n] = ans;
        return dp[n];
    }
    public int minDays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp)-1;
    }
}