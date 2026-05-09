class Solution {
    int solveNext(int[] nums , int s , int e , int k , int[] cost){
        int[][] dp = new int[nums.length+2][k+1];
        for(int[] a : dp){
            Arrays.fill(a , (int)(1e9));
        }
        dp[s][0] = 0;
        for(int i = s; i <= e; i++){
            for(int j = 0; j <= k; j++){
                dp[i+1][j] = Math.min(dp[i+1][j] , dp[i][j]);
                if(j+1 <= k)
                dp[i+2][j+1] = Math.min(dp[i+2][j+1] , cost[i]+dp[i][j]);
            }
        }
        return Math.min(dp[e+1][k] , dp[e+2][k]);
    }
    int solve(int[] nums , int k){
        if(k == 0)
        return 0;
        if(k > nums.length/2)
        return -1;
        if(nums.length == 2){
            if(nums[0] == nums[1])
            return 1;
            else
            return 0;
        }
        int[] cost = new int[nums.length];
        for(int i = 0; i <nums.length; i++){
        int pp = nums[(i-1+nums.length)%nums.length];
        int np = nums[(i+1)%nums.length];
        if(!(nums[i] > pp && nums[i] > np))
        cost[i] = Math.max(pp , np)+1-nums[i];
        }
        int include = 0;
        if(k > 0)
        include = cost[0]+solveNext(nums , 2 , nums.length-2 , k-1 , cost);
        int exclude = solveNext(nums , 1 , nums.length-1 , k , cost);
        int ans = Math.min(include , exclude);
        return ans;
    }
    public int minOperations(int[] nums, int k) {
        
        int ans = solve(nums , k);
        if(ans >= (int)(1e9))
        return -1;
        return ans;
    }
}