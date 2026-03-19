class Solution {
    final int mod = 1000000007;
    long binExpo(long base , long exp){
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    int solve(int[] nums , int k , int i , int[][] dp){
        if(i >= nums.length){
            if(k > 0)
            return 1;
            else
            return 0;
        }
        if(dp[k][i] != -1)
        return dp[k][i];
        int include = 0;
        if(k-nums[i] >= 0)
        include = solve(nums , k-nums[i] , i+1 , dp)%mod;
        int exclude = solve(nums , k , i+1 , dp)%mod;
        int ans = (include+exclude)%mod;
        dp[k][i] = ans;
        return dp[k][i];
    }
    public int countPartitions(int[] nums, int k) {
        long s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        if(s < 2*k)
        return 0;
        int[][] dp = new int[k+1][nums.length];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return (int)(binExpo(2 , nums.length)-(2*solve(nums , k , 0 , dp))%mod+mod)%mod;
    }
}