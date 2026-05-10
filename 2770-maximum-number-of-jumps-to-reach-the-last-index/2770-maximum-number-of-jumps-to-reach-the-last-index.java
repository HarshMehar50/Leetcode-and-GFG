class Solution {
    int solve(int[] nums , int target , int i , int[] dp){
        if(i == nums.length-1)
            return 0;
        if(i >= nums.length)
            return -1;
        if(dp[i] != Integer.MIN_VALUE)
            return dp[i];
        int ans = -1;
        for(int j = i+1; j < nums.length; j++){
            if(Math.abs(nums[i]-nums[j]) <= target){
                int nj = solve(nums , target , j , dp);
                if(nj != -1)
                    ans = Math.max(1+nj , ans);
            }
        }
        dp[i] = ans;
        return dp[i];
    }
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , Integer.MIN_VALUE);
        return solve(nums , target , 0 , dp);
    }
}