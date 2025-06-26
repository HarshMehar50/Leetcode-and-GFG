class Solution {
    int solve(int[] nums , int k , int op1 , int op2 , int i , int[][][] dp){
        if(i >= nums.length)
            return 0;
        if(dp[i][op1][op2] != -1)
            return dp[i][op1][op2];
        int includeop1 = Integer.MIN_VALUE;
        int includeop2 = Integer.MIN_VALUE;
        int includeop1op2 = Integer.MIN_VALUE;
        int includeop2op1 = Integer.MIN_VALUE;
        if(op1 > 0)
            includeop1 = (nums[i]-(int)Math.ceil(nums[i]/2.00))+solve(nums , k , op1-1 , op2 , i+1 , dp);
        if(op2 > 0 && nums[i] >= k)
            includeop2 = k+solve(nums , k , op1 , op2-1 , i+1 , dp);
        if(op1 > 0 && op2 > 0){
            if(nums[i] >= k)
                includeop2op1 = (nums[i]-(int)Math.ceil((nums[i]-k)/2.00))+solve(nums , k , op1-1 , op2-1 , i+1 , dp);
            if((int)Math.ceil(nums[i]/2.00) >= k)
                includeop1op2 = (nums[i]-(int)Math.ceil(nums[i]/2.00)+k)+solve(nums , k , op1-1 , op2-1 , i+1 , dp);
        }
        int exclude = solve(nums , k , op1 , op2 , i+1 , dp);
        int ans = Math.max(exclude , Math.max(Math.max(includeop1 , includeop2) , Math.max(includeop1op2 , includeop2op1)));
        dp[i][op1][op2] = ans;
        return dp[i][op1][op2];
    }
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        int[][][] dp = new int[nums.length][op1+1][op2+1];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        return s-solve(nums , k , op1 , op2 , 0 , dp);
    }
}