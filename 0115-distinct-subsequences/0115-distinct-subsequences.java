class Solution {
    int solve(String s , String t , int i , int j , int[][] dp){
        if(j < 0)
        return 1;
        if(i < 0)
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j))
        ans = solve(s , t , i-1 , j-1 , dp)+solve(s , t , i-1 , j , dp);
        else
        ans = solve(s , t , i-1 , j , dp);
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(s , t , s.length()-1 , t.length()-1 , dp);
    }
}