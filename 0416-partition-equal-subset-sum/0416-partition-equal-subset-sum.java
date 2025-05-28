class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        if(s%2 != 0)
        return false;
        boolean[][] dp = new boolean[nums.length][s+1];
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= s)
        dp[0][s] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= s; j++){
                boolean include = false;
                if(nums[i] <= j)
                include = dp[i-1][j-nums[i]];
                dp[i][j] = dp[i-1][j]|include;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(dp[i][s/2])
            return true;
        }
        return false;
    }
}