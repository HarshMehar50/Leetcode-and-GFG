class Solution {
    final int mod = 1000000007;
    long solve(int zero , int one , int limit , int k , long[][][] dp){
        if(one == 0 && zero == 0)
        return 1;
        if(zero == 0){
            if(one > 0 && one <= limit && k == 0)
            return 1;
            else
            return 0;
        }
        if(one == 0){
            if(zero > 0 && zero <= limit && k == 1)
            return 1;
            else
            return 0;
        }
        if(dp[zero][one][k] != -1)
        return dp[zero][one][k];
        long ans = 0;
        if((k&1) != 0){
            for(int i = 1; i <= Math.min(zero , limit); i++){
                ans = (ans+solve(zero-i , one , limit , 0 , dp))%mod;
            }
        }else{
            for(int i = 1; i <= Math.min(one , limit); i++){
                ans = (ans+solve(zero , one-i , limit , 1 , dp))%mod;
            }
        }
        dp[zero][one][k] = ans;
        return dp[zero][one][k];
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp1 = new long[zero+1][one+1][2];
        for(long[][] a : dp1){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        long[][][] dp2 = new long[zero+1][one+1][2];
        for(long[][] a : dp2){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        long ans = (solve(zero , one , limit , 1 , dp1)%mod+solve(zero , one , limit , 0 , dp2)%mod)%mod;
        return (int)ans;
    }
}