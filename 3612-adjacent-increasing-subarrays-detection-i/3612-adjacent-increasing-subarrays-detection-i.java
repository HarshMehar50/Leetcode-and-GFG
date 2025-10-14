class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp , 1);
        for(int i = 0; i < nums.size()-1; i++){
            if(nums.get(i) < nums.get(i+1))
            dp[i+1] += dp[i];
        }
        for(int i = 0; i < nums.size(); i++){
            if(dp[i] >= k && i+k < nums.size() && dp[i+k] >= k)
            return true;
        }
        return false;
    }
}