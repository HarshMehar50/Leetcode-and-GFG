class Solution {
    int solve(int[] nums , int sum , int i , int[][] dp){
        if(sum == 0)
        return 0;
        if(i >= nums.length)
        return (int)(1e9);
        if(dp[i][sum] != -1)
        return dp[i][sum];
        int ans = (int)(1e9);
        int v = nums[i];
        ans = Math.min(ans , solve(nums , sum , i+1 , dp));
        int op = 0;
        while(v > 0){
            v /= 2;
            op++;
            int next = (int)(1e9);
            if(v <= sum)
            next = solve(nums , sum-v , i+1 , dp);
            if(next != (int)(1e9))
            next += op;
            ans = Math.min(ans , next);
        }
        v = nums[i];
        op = 0;
        while(v <= sum){
            int next = solve(nums , sum-v , i+1 , dp);
            if(next != (int)(1e9))
            next += op;
            ans = Math.min(ans , next);
            op++;
            v *= 2;
        }
        dp[i][sum] = ans;
        return dp[i][sum];
    }
    public int minOperations(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum+1];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        int ans = solve(nums , sum , 0 , dp);
        if(ans == (int)(1e9))
        return -1;
        return ans;
    }
}