class Solution {
    int solve(int[] nums , int l , int r , int[][] dp){
        if(l > r)
            return 0;
        if(dp[l][r] != -1)
            return dp[l][r];
        int ans = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++){
            int s = nums[l-1]*nums[i]*nums[r+1];
            ans = Math.max(ans , s+solve(nums , l , i-1 , dp)+solve(nums , i+1 , r , dp));
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length+2];
        for(int i = 1; i < nums.length+1; i++){
            a[i] = nums[i-1];
        }
        a[0] = 1;
        a[a.length-1] = 1;
        int[][] dp = new int[a.length][a.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(a , 1 , nums.length , dp);
    }
}