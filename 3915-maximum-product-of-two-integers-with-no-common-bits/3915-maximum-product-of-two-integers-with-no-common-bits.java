class Solution {
    public long maxProduct(int[] nums) {
        long ans = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int msb = (int)(Math.log(max)/Math.log(2));
        int[] dp = new int[(1<<(msb+1))];
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] = nums[i];
        }
        for(int i = 0; i <= msb; i++){
            for(int mask = 0; mask < (1<<(msb+1))-1; mask++){
                if((mask&(1<<i)) != 0)
                dp[mask] = Math.max(dp[mask] , dp[mask^(1<<i)]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            ans = Math.max(ans , (long)((long)nums[i]*(long)dp[((1<<(msb+1))-1)^nums[i]]));
        }
        return ans;
    }
}