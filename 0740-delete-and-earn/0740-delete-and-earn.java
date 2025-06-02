class Solution {
    int solve(int[] nums , int index , int[] dp){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int include = 0;
        int exclude = 0;
        int i = index+1;
        int c = 0;
        for(i = index+1; i < nums.length && nums[i] <= nums[index]+1; i++){
            if(nums[i] == nums[index])
                c++;
        }
        include = nums[index]*(c+1)+solve(nums , i , dp);
        exclude = solve(nums , index+1 , dp);
        int ans = Math.max(include , exclude);
        dp[index]=ans;
        return dp[index];
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        return solve(nums , 0 , dp);
    }
}