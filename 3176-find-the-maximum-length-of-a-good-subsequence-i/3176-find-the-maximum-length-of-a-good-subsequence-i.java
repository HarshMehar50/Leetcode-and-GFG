class Solution {
    int solve(int[] nums , int k , int i , int p , int[][][] dp){
        if(i >= nums.length)
        return 0;
        if(dp[k][i][p+1] != -1)
        return dp[k][i][p+1];
        int include = 0;
        if(p == -1)
        include = 1+solve(nums , k , i+1 , i , dp);
        else{
            if(nums[p] != nums[i]){
                if(k > 0)
                include = 1+solve(nums , k-1 , i+1 , i , dp);
            }else
            include = 1+solve(nums , k , i+1 , i , dp);
        }
        int exclude = solve(nums , k , i+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[k][i][p+1] = ans;
        return dp[k][i][p+1];
    }
    public int maximumLength(int[] nums, int k) {
        int[][][] dp = new int[k+1][nums.length][nums.length+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(nums , k , 0 , -1 , dp);
    }
}