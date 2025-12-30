class Solution {
    final int mod = 1000000007;
    int solve(int n , int i , int p , int[][] dp){
        if(i == n)
        return 1;
        if(dp[i][p+1] != -1)
        return dp[i][p+1];
        int ans = 0;
        if(p == -1){
            for(int j = 0; j < 5; j++){
                ans = (ans+solve(n , i+1 , j , dp))%mod;
            } 
        }else if(p == 0)
        ans = (ans+solve(n , i+1 , 1 , dp))%mod;
        else if(p == 1)
        ans = (ans+solve(n , i+1 , 0 , dp)+solve(n , i+1 , 2 , dp))%mod;
        else if(p == 2){
            for(int j = 0; j < 5; j++){
                if(j != 2)
                ans = (ans+solve(n , i+1 , j , dp))%mod;
            }
        }else if(p == 3)
        ans = (ans+solve(n , i+1 , 2 , dp)+solve(n , i+1 , 4 , dp))%mod;
        else
        ans = (ans+solve(n , i+1 , 0 , dp))%mod;
        dp[i][p+1] = ans;
        return dp[i][p+1];
    }
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n+1][6];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(n , 0 , -1 , dp);
    }
}