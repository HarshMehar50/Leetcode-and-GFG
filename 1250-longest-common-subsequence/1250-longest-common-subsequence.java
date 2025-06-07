class Solution {
    int solveTab(String text1, String text2){
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int j = 0; j < dp[0].length; j++){
            dp[text1.length()][j] = 0;
        }
        for(int i = 0; i < dp.length; i++){
            dp[i][text2.length()] = 0;
        }
        for(int i = text1.length()-1; i >= 0; i--){
            for(int j = text2.length()-1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
    int solve(String text1, String text2 , int i , int j , int[][] dp){
        if(i == text1.length()){
            return 0;
        }
        if(j == text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int move1 = 0;
        int move2 = 0;
        int ans = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return 1+solve(text1 , text2 , i+1, j+1 , dp);
        }else{
            move1 = solve(text1, text2 , i+1 , j , dp);
            move2 = solve(text1 , text2 , i , j+1 , dp);
            ans = Math.max(move1 , move2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        /*int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(text1 , text2 , 0 , 0 , dp);*/
        return solveTab(text1 , text2);
    }
}