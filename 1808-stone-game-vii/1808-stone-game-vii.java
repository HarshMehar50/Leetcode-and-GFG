class Solution {
    int solve(int[] stones , int[] ps , int l , int r , boolean alice , int[][] dp){
        if(l > r)
            return 0;
        if(dp[l][r] != -1)
            return dp[l][r];
        int cs = 0;
        if(l == 0)
            cs = ps[r];
        else
            cs = ps[r]-ps[l-1];
        int ans = -1;
        if(alice)
            ans = Integer.MIN_VALUE;
        else
            ans = Integer.MAX_VALUE;
        if(alice){
            int left = (cs-stones[l])+solve(stones , ps , l+1 , r , !alice , dp);
            int right = (cs-stones[r])+solve(stones , ps , l , r-1 , !alice , dp);
            ans = Math.max(ans , Math.max(left , right));
        }else{
            int left = solve(stones , ps , l+1 , r , !alice , dp)-(cs-stones[l]);
            int right = solve(stones , ps , l , r-1 , !alice , dp)-(cs-stones[r]);
            ans = Math.min(ans , Math.min(left , right));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
    public int stoneGameVII(int[] stones) {
        int[] ps = new int[stones.length];
        ps[0] = stones[0];
        for(int i = 1; i < stones.length; i++){
            ps[i] = ps[i-1]+stones[i];
        }
        int[][] dp = new int[stones.length][stones.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(stones , ps , 0 , stones.length-1 , true , dp);
    }
}