class Solution {
    int solve(int[] stoneValue , int[] ps , int l , int r , int[][] dp){
        if(l == r || l >= r)
            return 0;
        if(dp[l][r] != -1)
            return dp[l][r];
        int ans = 0;
        for(int i = l+1; i <= r; i++){
            int ls = ps[i]-ps[l];
            int rs = ps[r+1]-ps[i];
            if(ls > rs)
                ans = Math.max(ans , rs+solve(stoneValue , ps , i , r , dp));
            else if(rs > ls)
                ans = Math.max(ans , ls+solve(stoneValue , ps , l , i-1 , dp));
            else
                ans = Math.max(ans , Math.max(ls+solve(stoneValue , ps , i , r , dp) , rs+solve(stoneValue , ps , l , i-1 , dp)));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
    public int stoneGameV(int[] stoneValue) {
        int[] ps = new int[stoneValue.length+1];
        for(int i = 0; i < ps.length-1; i++){
            ps[i+1] = ps[i]+stoneValue[i];
        }
        int[][] dp = new int[stoneValue.length+1][stoneValue.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(stoneValue , ps , 0 , stoneValue.length-1 , dp);
    }
}