class Solution {
    final int mod = 1000000007;
    int solve(int[] nums , int i , int p , int[][] dp){
        if(i >= nums.length)
        return 1;
        if(dp[i][p+1] != -1)
        return dp[i][p+1];
        int ans = 0;
        if(p == -1){
            for(int j = 0; j <= nums[i]; j++){
                ans = (ans+solve(nums , i+1 , j , dp))%mod;
            }
        }else{
            int ps = nums[i-1];
            int p2 = ps-p;
            for(int j = 0; j <= nums[i]; j++){
                if(j >= p && nums[i]-j <= p2)
                ans = (ans+solve(nums , i+1 , j , dp))%mod;
            }
        }
        dp[i][p+1] = ans;
        return dp[i][p+1];
    }
    public int countOfPairs(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int[][] dp = new int[nums.length][max+2];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(nums , 0 , -1 , dp);
    }
}