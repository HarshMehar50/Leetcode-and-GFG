class Solution {
    int solve(int[] nums, int target , int i , int s , int[][] dp){
        if(i == nums.length){
            if(s == target)
                return 1;
            else return 0;
        }
        if(dp[i][s+1000] != -1)
            return dp[i][s+1000];
        int p = solve(nums , target , i+1 , s+nums[i] , dp);
        int m = solve(nums , target , i+1 , s-nums[i] , dp);
        int ans = p+m;
        dp[i][s+1000] = ans;
        return dp[i][s+1000];
    }
    int solveRec(int[] nums, int target , int i , int s){
        if(i == nums.length){
            if(s == target)
                return 1;
            else return 0;
        }
        int p = solveRec(nums , target , i+1 , s+nums[i]);
        int m = solveRec(nums , target , i+1 , s-nums[i]);
        int ans = p+m;
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums , target , 0 , 0 , dp);
        //return solveRec(nums , target , 0 , 0);
    }
}