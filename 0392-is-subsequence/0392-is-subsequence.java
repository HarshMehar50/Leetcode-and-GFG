class Solution {
    int solve(String s , String t , int i , int j , int[][] dp){
        if(i >= s.length() || j >= t.length())
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
        return 1+solve(s , t , i+1 , j+1 , dp);
        else{
            int s1 = solve(s , t , i+1 , j , dp);
            int s2 = solve(s , t , i , j+1 , dp);
            int ans = Math.max(s1 , s2);
            dp[i][j] = ans;
            return dp[i][j];
        }
    }
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int ans = solve(s , t , 0 , 0 , dp);
        if(ans == s.length())
        return true;
        else
        return false;
    }
}