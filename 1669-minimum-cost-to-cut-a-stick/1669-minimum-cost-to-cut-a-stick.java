class Solution {
    int solve(int n , int[] cuts , int l , int r , int[][] dp){
        if(l > r)
            return 0;
        if(dp[l][r] != -1)
            return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            int left = 0;
            int right = 0;
            if(l-1 < 0)
                left = 0;
            else
                left = cuts[l-1];
            if(r+1 >= cuts.length)
                right = n;
            else
                right = cuts[r+1];
            ans = Math.min(ans , right-left+solve(n , cuts , l , i-1 , dp)+solve(n , cuts , i+1 , r , dp));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
    public int minCost(int n, int[] cuts) {
        /*int[] a = new int[n+2];
        a[0] = 0;
        for(int i = 0; i < cuts.length; i++){
            a[i+1] = cuts[i];
        }
        a[n+1] = n;
        Arrays.sort(a);*/
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length+2][cuts.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(n , cuts , 0 , cuts.length-1 , dp);
    }
}