class Solution {
    final int mod = 1000000007;
    int solve(int[] nums , int i , int p1 , int p2 , int[][][] dp){
        if(i >= nums.length)
        return 1;
        if(dp[i][p1+1][p2+1] != -1)
        return dp[i][p1+1][p2+1];
        int ans = 0;
        if(p1 == -1 && p2 == -1){
            for(int j = 0; j <= nums[i]; j++){
                ans = (ans+solve(nums , i+1 , j , nums[i]-j , dp))%mod;
            }
        }else{
            for(int j = 0; j <= nums[i]; j++){
                if(j >= p1 && nums[i]-j <= p2)
                ans = (ans+solve(nums , i+1 , j , nums[i]-j , dp))%mod;
            }
        }
        dp[i][p1+1][p2+1] = ans;
        return dp[i][p1+1][p2+1];
    }
    public int countOfPairs(int[] nums) {
        int[][][] dp = new int[nums.length][52][52];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(nums , 0 , -1 , -1 , dp);
    }
}