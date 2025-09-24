class Solution {
    final int mod = 1000000007;
    int solve(int[] nums , int i , int sl , int p , int[][][] dp){
        if(i >= nums.length)
        return 1;
        if(dp[i][sl][p+1] != -1)
        return dp[i][sl][p+1];
        int include = 0;
        if(sl <= 1){
            if(p == -1 && sl == 0)
            include = solve(nums , i+1 , sl+1 , nums[i]%2 , dp)%mod;
            else if(sl == 1){
                if(p == nums[i]%2)
                include = solve(nums , i+1 , sl+1 , nums[i]%2 , dp)%mod;
                else
                include = solve(nums , i+1 , 1 , nums[i]%2 , dp)%mod;
            }
        }else if(sl == 2 && p != nums[i]%2)
        include = solve(nums , i+1 , 1 , nums[i]%2 , dp)%mod;
        int exclude = solve(nums , i+1 , sl , p , dp)%mod;
        int ans = (include+exclude)%mod;
        dp[i][sl][p+1] = ans;
        return dp[i][sl][p+1];
    }
    public int countStableSubsequences(int[] nums) {
        int[][][] dp = new int[nums.length][3][3];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return (solve(nums , 0 , 0 , -1 , dp)-1+mod)%mod;
    }
}