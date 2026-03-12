class Solution {
    final int mod = 1000000007;
    int solve(int[] nums , int p , int mask , int[][] dp){
        if(mask == (1<<nums.length)-1)
        return 1;
        if(dp[p+1][mask] != -1)
        return dp[p+1][mask];
        int ans = 0;
        for(int j = 0; j < nums.length; j++){
            if((mask&(1<<j)) == 0){
                if(p == -1 || (p != -1 && (nums[j]%nums[p] == 0 || nums[p]%nums[j] == 0)))
                ans = (ans+solve(nums , j , mask|(1<<j) , dp))%mod;
            }
        }
        dp[p+1][mask] = ans;
        return dp[p+1][mask];
    }
    public int specialPerm(int[] nums) {
        int[][] dp = new int[nums.length+1][(1<<nums.length)];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(nums , -1 , 0 , dp);
    }
}