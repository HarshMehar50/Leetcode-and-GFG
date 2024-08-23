class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int s = 0;
        int s0 = 0;
        for(int i = 0; i < n; i++){
            s += nums[i];
        }
        for(int i = 0; i < n; i++){
            s0 += (nums[i]*i);
        }
        dp[0] = s0;
        for(int i = 1; i < n; i++){
            dp[i] = dp[i-1] - (nums[n-i]*(n-1)) + (s-nums[n-i]);
        }
        Arrays.sort(dp);
        return dp[n-1];
    }
}