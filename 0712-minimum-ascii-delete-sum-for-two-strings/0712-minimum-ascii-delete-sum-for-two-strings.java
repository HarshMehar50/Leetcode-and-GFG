class Solution {
    int solveTab(String s1 , String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int j = 0; j < dp[0].length; j++){
            dp[s1.length()][j] = 0;
        }
        for(int i = 0; i < dp.length; i++){
            dp[i][s2.length()] = 0;
        }
        for(int i = s1.length()-1; i >= 0; i--){
            for(int j = s2.length()-1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = (int)s1.charAt(i)+dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
    int solve(String s1 , String s2 , int i , int j , int[][] dp){
        if(i == s1.length()){
            return 0;
        }
        if(j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int move1 = 0;
        int move2 = 0;
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return ((int)s1.charAt(i))+solve(s1, s2 , i+1, j+1 , dp);
        }else{
            move1 = solve(s1, s2 , i+1 , j , dp);
            move2 = solve(s1 , s2 , i , j+1 , dp);
            ans = Math.max(move1 , move2);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int common = solve(s1 , s2 , 0 , 0 , dp);
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < s1.length(); i++){
            sum1 += (int)s1.charAt(i);
        }
        for(int i = 0; i < s2.length(); i++){
            sum2 += (int)s2.charAt(i);
        }
        return sum1 + sum2 -(2*common);

    }
}