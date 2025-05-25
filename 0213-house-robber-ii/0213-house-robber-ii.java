class Solution {
    int solveTab(int[] nums , int start , int end){
        int[] dp = new int[nums.length+2];
        for(int i = end ; i >= start; i--){
            dp[i] = Math.max(dp[i+1] ,nums[i]+dp[i+2]);
        }
        return dp[start];
    }
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else{
            int c1 = solveTab(nums , 0 , nums.length-2);
            int c2 = solveTab(nums , 1 , nums.length-1);
            return Math.max(c1 , c2);
        }
    }
}