class Solution {
    int solve(List<Integer> nums , int target , int i , int[][] dp){
        if(target == 0)
        return 0;
        if(target < 0 || i >= nums.size())
        return Integer.MIN_VALUE;
        if(dp[target][i] != -1)
        return dp[target][i];
        int include = 1+solve(nums , target-nums.get(i) , i+1 , dp);
        int exclude = solve(nums , target , i+1 , dp);
        int ans = Math.max(include , exclude);
        dp[target][i] = ans;
        return dp[target][i];
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[target+1][nums.size()];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        } 
        int ans = solve(nums , target , 0 , dp);
        if(ans < 0)
        return -1;
        return ans;
    }
}