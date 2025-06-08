class Solution {
    int solve(int[] nums , int index , int sum , int[][] dp){
        if(index == nums.length && sum%3 == 0){
            return sum;
        }
        if(index >= nums.length){
            return 0;
        }
        if(dp[index][sum%3] != -1)
        return dp[index][sum%3];
        int include = solve(nums , index+1 , sum+nums[index] , dp);
        int exclude = solve(nums , index+1 , sum , dp);
        int maxSum = Math.max(include, exclude);
        dp[index][sum%3] = maxSum;
        return dp[index][sum%3];
    }
    int solveTab(int[] nums){
        int[][] dp = new int[nums.length+1][3];
        for(int i = 1; i < nums.length+1; i++){
            for(int j = 0; j < 3; ++j){
                dp[i][j] = dp[i-1][j];
            }
            for(int j = 0; j < 3; ++j){
                int x = dp[i-1][j]+nums[i-1];
                int y = x%3;
                dp[i][y] = Math.max(dp[i][y] , x);
            }
        }
        return dp[nums.length][0];
    }
    public int maxSumDivThree(int[] nums) {
        /*int[][] dp = new int[nums.length][3];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }*/
        return solveTab(nums);
        //return solve(nums , 0 , 0 , dp);
    }
}