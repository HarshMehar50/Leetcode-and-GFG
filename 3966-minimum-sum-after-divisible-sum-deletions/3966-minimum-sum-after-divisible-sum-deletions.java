class Solution {
    public long minArraySum(int[] nums, int k) {
        long[] best = new long[k];
        long[] dp = new long[nums.length];
        long[] ps = new long[nums.length];
        Arrays.fill(best , Long.MIN_VALUE);
        best[0] = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                dp[i] = dp[i-1];
                ps[i] += ps[i-1];
            }
            ps[i] += nums[i];
            if(best[(int)(ps[i]%k)] != Long.MIN_VALUE)
            dp[i] = Math.max(dp[i] , ps[i]+best[(int)(ps[i]%k)]);
            best[(int)(ps[i]%k)] = Math.max(best[(int)(ps[i]%k)] , dp[i]-ps[i]);
        }
        return ps[ps.length-1]-dp[dp.length-1];
    }
}