class Solution {
    /*int solve(String s1 , String s2 , int i , int j){
        if(i >= s1.length() || j >= s2.length())
        return 0;
        if(s1.charAt(i) == s2.charAt(j))
        return solve(s1 , s2 , i+1 , j+1);
        else{
            int insert1 = 2+solve(s1 , s2 , i+1 , j+2);
            int insert2 = 2+solve(s1 , s2 , i+2 , j+1);
            int ans = Math.min(insert1 , insert2);
            return ans;
        }
    }*/
    /*String s1 = "";
        String s2 = "";
        for(int i = 0; i < s.length()/2; i++){
            s1 += s.charAt(i);
        }
        for(int i = s.length()-1; i >= s.length()/2; i--){
            s2 += s.charAt(i);
        }
        if(s.length()%2 != 0)
        s1 += s.charAt(s.length()/2);
        return solve(s1 , s2 , 0 , 0);*/
    int solve(String s , int i , int j , int[][] dp){
        if(i >= j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == s.charAt(j))
            return solve(s , i+1 , j-1 , dp);
        else{
            int c1 = 1+solve(s , i , j-1 , dp);
            int c2 = 1+solve(s , i+1 , j , dp);
            int ans = Math.min(c1 , c2);
            dp[i][j] = ans;
        }
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(s , 0 , s.length()-1 , dp);
    }
}