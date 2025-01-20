class Solution {
    int[] dR = {-2 , -2 , -1 , -1 , 1 , 1 , 2 , 2};
    int[] dC = {-1 , 1 , -2 , 2 , -2 , 2 , -1 , 1};
    double solve(int n , int k , int r , int c , double[][][] dp){
        if(r < 0 || r >= n || c < 0 || c >= n)
        return 0;
        if(k == 0)
        return 1;
        if(dp[k][r][c] != -1)
        return dp[k][r][c];
        double ans = 0;
        for(int i = 0; i < 8; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            ans += (double)(solve(n , k-1 , nr , nc , dp));
        }
        ans = ans/8;
        dp[k][r][c] = ans;
        return dp[k][r][c];
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(double[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        return solve(n , k , row , column , dp);
    }
}