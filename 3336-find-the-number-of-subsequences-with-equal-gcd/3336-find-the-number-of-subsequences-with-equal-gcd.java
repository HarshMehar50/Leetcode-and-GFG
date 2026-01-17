class Solution {
    final int mod = 1000000007;
    int GCD(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return GCD(b , a%b);
    }
    /*int solve(int[] nums , int i , int target , int g , int[][] gcd){
        if(i == nums.length){
            if(g == target)
            return 1;
            else
            return 0;
        }
        int ans = 0;
        if(gcd[g][nums[i]] >= target)
        ans = (ans+solve(nums , i+1 , target , gcd[g][nums[i]] , gcd))%mod;
        ans = (ans+solve(nums , i+1 , target , g , gcd))%mod;
        return ans;
    }*/
    int solve(int[] nums , int[][] gcd , int i , int g1 , int g2 , int[][][] dp){
        if(i >= nums.length){
            if(g1 == g2)
            return 1;
            else
            return 0;
        }
        if(dp[i][g1][g2] != -1)
        return dp[i][g1][g2];
        int include1 = solve(nums , gcd , i+1 , gcd[g1][nums[i]] , g2 , dp)%mod;
        int include2 = solve(nums , gcd , i+1 , g1 , gcd[g2][nums[i]] , dp)%mod;
        int exclude = solve(nums , gcd , i+1 , g1 , g2 , dp)%mod;
        int ans = (((include1+include2)%mod)+exclude)%mod;
        dp[i][g1][g2] = ans;
        return dp[i][g1][g2];
    }
    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int[][] gcd = new int[max+1][max+1];
        for(int i = 0; i <= max; i++){
            for(int j = 0; j <= max; j++){
                gcd[i][j] = GCD(i , j);
            }
        }
        /*int ans = 0;
        for(int i = 1; i <= max; i++){
            ans = (ans+solve(nums , 0 , i , 0 , gcd))%mod;
        }
        return ans*/;
        int[][][] dp = new int[nums.length][max+1][max+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return (solve(nums , gcd , 0 , 0 , 0 , dp)-1+mod)%mod;
    }
}