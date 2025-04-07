class Solution {
    boolean solve(int[] nums , int index , int target , boolean[][] dp){
        if(target == 0){
            return true;
        }
        if(index >= nums.length){
            return false;
        }
        if(target < 0){
            return false;
        }
        if(dp[index][target] != true){
            return dp[index][target];
        }
        boolean include = solve(nums , index+1 , target-nums[index] , dp);
        boolean exclude = solve(nums , index+1 , target , dp);
        boolean ans = include | exclude;
        dp[index][target] = ans;
        return dp[index][target];
    }
    boolean solveTab(int[] nums , int target){
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = 0; j <= target; j++){
                boolean include = false; 
                if(j-nums[i] >= 0)
                include = dp[i+1][j-nums[i]];
                boolean exclude = dp[i+1][j];
                dp[i][j] = include || exclude;
            }
        }
        return dp[0][target];
    }
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
       /* boolean[][] dp = new boolean[nums.length][s/2 + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <dp[0].length; j++){
                dp[i][j] = false;
            }
        }*/
        if(s%2 == 0){
            return solveTab(nums , s/2);
        }else{
            return false;
        }
    }
}