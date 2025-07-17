class Solution {
    int solve(int[] nums , int[] multipliers , int l , int r , int i , int[][][] dp){
        if(i >= multipliers.length || l > r)
            return 0;
        int r1 = nums.length-1-r;
        int rf = multipliers.length-1-r1;
        if(dp[l][rf][i] != -1)
            return dp[l][rf][i];
        int ans = 0;
        ans = Math.max((nums[l]*multipliers[i])+solve(nums , multipliers , l+1 , r , i+1 , dp) , (nums[r]*multipliers[i])+solve(nums , multipliers , l , r-1 , i+1 , dp));
        dp[l][rf][i] = ans;
        return dp[l][rf][i];
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        // dp(l , r , i) = max(m[i]*a[l]+dp(l+1 , r , i+1) , m[i]*a[r]+dp(l , r-1 , i+1))
        int[][][] dp = new int[multipliers.length][multipliers.length][multipliers.length];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        return solve(nums , multipliers , 0 , nums.length-1 , 0 , dp);
    }
}