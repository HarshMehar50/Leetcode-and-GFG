class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    final int mod = 1000000007;
    int solve(int[][] mat , int i , int g , int[][] dp){
        if(i >= mat.length){
            if(g == 1)
            return 1;
            else
            return 0;
        }
        if(dp[i][g] != -1)
        return dp[i][g];
        int ans = 0;
        for(int j = 0; j < mat[0].length; j++){
            ans = (ans+solve(mat , i+1 , gcd(mat[i][j] , g) , dp))%mod;
        } 
        dp[i][g] = ans;
        return dp[i][g];
    }
    public int countCoprime(int[][] mat) {
        int[][] dp = new int[mat.length][151];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(mat , 0 , 0 , dp);
    }
}