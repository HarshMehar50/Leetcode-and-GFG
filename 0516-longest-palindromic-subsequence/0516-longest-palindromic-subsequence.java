class Solution {
    int solveTab(String s , String r){
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int j = 0; j < dp[0].length; j++){
            dp[s.length()][j] = 0;
        }
        for(int i = 0; i < dp.length; i++){
            dp[i][s.length()] = 0;
        }
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = r.length()-1; j >= 0; j--){
                if(s.charAt(i) == r.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
    int solve(String s , String r , int i , int j , int[][] dp){
        if(i == s.length()){
            return 0;
        }
        if(j == r.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int move1 = 0;
        int move2 = 0;
        int ans = 0;
        if(s.charAt(i) == r.charAt(j)){
            return 1+solve(s , r , i+1, j+1 , dp);
        }else{
            move1 = solve(s , r , i+1 , j , dp);
            move2 = solve(s , r , i , j+1 , dp);
            ans = Math.max(move1 , move2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        String r = "";
        for(int i = s.length()-1; i >= 0; i--){
            r += s.charAt(i);
        }
        return solve(s , r , 0 , 0 , dp);
    }
}