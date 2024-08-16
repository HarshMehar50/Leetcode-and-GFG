class Solution {
    // tabulation method is based and possible on 1 based indexing
    boolean solveTab(String s , String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j++){
            boolean track = true;
            for(int k = 1; k <= j; k++){
                if(p.charAt(k-1) != '*'){
                    track = false;
                    break;
                }
            }
            dp[0][j] = track;
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i-1) == p.charAt(j-1))
                dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                dp[i][j] = dp[i][j-1] || dp[i-1][j];
                else
                dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }
    boolean solve(String s , String p , int i , int j){
        if(i < 0 && j < 0){
            return true;
        }
        if(i >= 0 && j < 0){
            return false;
        }
        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return solve(s , p , i-1 , j-1);
        }else if(p.charAt(j) == '*'){
            return solve(s , p , i-1 , j)||solve(s , p , i , j-1);
        }else{
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        //return solve(s , p , s.length()-1 , p.length()-1);
        return solveTab(s , p);
    }
}