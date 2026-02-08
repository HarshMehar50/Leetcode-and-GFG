class Solution {
    /*long solve(int[] nums1 , int[] nums2 , int k , int i , int j , long[][][] dp){
        if(k == 0)
        return 0;
        if(i == nums1.length || j == nums2.length)
        return Long.MIN_VALUE/4;
        if(dp[k][i][j] != Long.MIN_VALUE/4)
        return dp[k][i][j];
        long ans = Long.MIN_VALUE/4;
        long include = (long)((long)nums1[i]*(long)nums2[j])+solve(nums1 , nums2 , k-1 , i+1 , j+1 , dp);
        long exclude1 = solve(nums1 , nums2 , k , i+1 , j , dp);
        long exclude2 = solve(nums1 , nums2 , k , i , j+1 , dp);
        ans = Math.max(ans , include);
        ans = Math.max(ans , exclude1);
        ans = Math.max(ans , exclude2);
        dp[k][i][j] = ans;
        return dp[k][i][j];
    }*/
    public long maxScore(int[] nums1, int[] nums2, int k) {
        /*long[][][] dp = new long[k+1][nums1.length][nums2.length];
        for(long[][] a : dp){
            for(long[] b : a){
                Arrays.fill(b , Long.MIN_VALUE/4);
            }
        }
        return solve(nums1 , nums2 , k , 0 , 0 , dp);*/
        long[][][] dp = new long[nums1.length+1][nums2.length+1][k+1];
        for(long[][] a : dp){
            for(long[] b : a){
                Arrays.fill(b , Long.MIN_VALUE/4);
            }
        }
        dp[0][0][0] = 0;
        for(int i = 0; i <= nums1.length; i++){
            for(int j = 0; j <= nums2.length; j++){
                for(int l = 0; l <= k; l++){
                    if(i > 0)
                    dp[i][j][l] = Math.max(dp[i][j][l] , dp[i-1][j][l]);
                    if(j > 0)
                    dp[i][j][l] = Math.max(dp[i][j][l] , dp[i][j-1][l]);
                    if(i > 0 && j > 0 && l > 0 && dp[i-1][j-1][l-1] != Long.MIN_VALUE/4)
                    dp[i][j][l] = Math.max(dp[i][j][l] , (long)((long)nums1[i-1]*(long)nums2[j-1])+dp[i-1][j-1][l-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length][k];
    }
}