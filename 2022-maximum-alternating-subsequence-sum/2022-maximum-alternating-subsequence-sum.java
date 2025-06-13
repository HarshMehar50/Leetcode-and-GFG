class Solution {
    long solve(int[] nums , int index , int c , long[][] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index][c] != -1){
            return dp[index][c];
        }
        long include = 0;
        if(c == 1){
            include = nums[index]+solve(nums , index+1 , 0 , dp);
        }else{
            include = -nums[index]+solve(nums , index+1 , 1 , dp);
        }
        long exclude = solve(nums , index+1 , c , dp);
        long ans = Math.max(include , exclude);
        dp[index][c] = ans;
        return dp[index][c];
    }
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for(int i =0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums , 0 , 1 , dp);
    }
}