class Solution {
    int solveTab(String word1 , String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int j = 0; j < dp[0].length; j++){
            dp[word1.length()][j] = word2.length()-j;
        }
        for(int i = 0; i < dp.length; i++){
            dp[i][word2.length()] = word1.length()-i;
        }
        for(int i = word1.length()-1; i >= 0; i--){
            for(int j = word2.length()-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(1+dp[i+1][j] , 1+dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    int solve(String word1 , String word2 , int i , int j , int[][] dp){
        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()){
            return word1.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int delete1 = 0;
        int delete2 = 0;
        int ans = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            return solve(word1 , word2 , i+1 , j+1 , dp);
        }else{
            delete1 = 1+solve(word1 , word2 , i+1 , j , dp);
            delete2 = 1+solve(word1 , word2 , i , j+1 , dp);
            ans = Math.min(delete1 , delete2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(word1 , word2 , 0 , 0 , dp);
        //return solveTab(word1 , word2);
    }
}