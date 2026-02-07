class Solution {
    final int mod = 1000000007;
    int solve(int[] nums , int i , int p , int[][] dp){
        if(i >= nums.length){
            if(p == 2)
            return 1;
            else
            return 0;
        }
        if(dp[i][p+1] != -1)
        return dp[i][p+1];
        int include = 0;
        if(nums[i] == p || nums[i] == p+1)
        include = solve(nums , i+1 , nums[i] , dp)%mod;
        int exclude = solve(nums , i+1 , p , dp)%mod;
        int ans = (include+exclude)%mod;
        dp[i][p+1] = ans;
        return dp[i][p+1];
    }
    public int countSpecialSubsequences(int[] nums) {
        int[][] dp = new int[nums.length][4];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(nums , 0 , -1 , dp);
    }
}