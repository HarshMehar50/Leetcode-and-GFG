class Solution {
    final int mod = 1000000007;
    /*int solve(int n , int x , int p , int[][] dp){
        if(n == 0)
        return 1;
        if(dp[n][p] != -1)
        return dp[n][p];
        int ans = 0;
        for(int i = p+1; (int)Math.pow(i , x) <= n; i++){
            ans = (ans+solve(n-(int)Math.pow(i , x) , x , i , dp))%mod;
        }
        dp[n][p] = ans;
        return dp[n][p];
    }*/
    int solve(int n , List<Integer> l , int x , int i , int[][] dp){
        if(n == 0)
        return 1;
        if(i == l.size() || n < 0)
        return 0;
        if(dp[n][i] != -1)
        return dp[n][i];
        int ans = solve(n , l , x , i+1 , dp);
        if(l.get(i) <= n)
        ans = (ans+solve(n-l.get(i) , l , x , i+1 , dp))%mod;
        dp[n][i] = ans;
        return dp[n][i];
    }
    public int numberOfWays(int n, int x) {
        /*int[][] dp = new int[n+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(n , x , 0 , dp);*/
        List<Integer> l = new ArrayList<>();
        for(int i = 1; (int)Math.pow(i , x) <= n; i++){
            l.add((int)Math.pow(i , x));
        }
        int[][] dp = new int[n+1][l.size()];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(n , l , x , 0 , dp);
    }
}