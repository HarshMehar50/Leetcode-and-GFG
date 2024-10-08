class Solution {
    double solve(int poured , int i , int j , double[][] dp){
        if(i < 0 || j < 0 || j > i)
        return 0;
        /*if(i == 0 && j == 0)
        dp[i][j] = poured;*/
        dp[0][0] = poured;
        if(dp[i][j] != -1)
        return dp[i][j];
        double left = (solve(poured , i-1 , j-1 , dp)-1)/2;
        double right = (solve(poured , i-1 , j , dp)-1)/2;
        if(left < 0)
        left = 0;
        if(right < 0)
        right = 0;
        double ans = left+right;
        dp[i][j] = ans;
        return dp[i][j]; 
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_glass+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        double ans = solve(poured , query_row , query_glass , dp);
        if(ans > 1)
        return 1;
        else return ans;
    }
}