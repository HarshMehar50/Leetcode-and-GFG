// User function Template for Java

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    static int solve(String s1 , String s2 , int i , int j , int[][] dp){
        if(i >= s1.length() || j >= s2.length())
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
        return 1+solve(s1 , s2 , i+1 , j+1 , dp);
        else{
            int ans = Math.max(solve(s1 , s2 , i+1 , j , dp) , solve(s1 , s2 , i , j+1 , dp));
            dp[i][j] = ans;
        }
        return dp[i][j];
    } 
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int lcs = solve(s1 , s2 , 0 , 0 , dp);
        return s1.length()+s2.length()-lcs;
    }
}