class Solution {
    // Function to calculate the number of subsets with a given sum
    int solve(int[] nums , int target , int i , int s , int[][] dp){
        if(i >= nums.length){
            if(s == target)
            return 1;
            else
            return 0;
        }
        if(dp[i][s] != -1)
        return dp[i][s];
        int include = 0;
        if(s+nums[i] <= target)
        include = solve(nums , target , i+1 , s+nums[i] , dp);
        int exclude = solve(nums , target , i+1 , s , dp);
        int ans = include+exclude;
        dp[i][s] = ans;
        return dp[i][s];
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target+1];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(nums , target , 0 , 0 , dp);
    }
}