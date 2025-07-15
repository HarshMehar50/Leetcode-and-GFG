class Solution {
    public boolean checkPartitioning(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int l = 1; l <= s.length(); l++){
            for(int i = 0; i+l-1 < s.length(); i++){
                int j = i+l-1;
                if(i == j)
                dp[i][j] = true;
                else if(i+1 == j && s.charAt(i) == s.charAt(j))
                dp[i][j] = true;
                else
                dp[i][j] = dp[i+1][j-1]&&(s.charAt(i) == s.charAt(j));
            }
        }
        for(int i = 1; i < s.length()-1; i++){
            for(int j = s.length()-2; j >= i; j--){
                if(dp[i][j] && dp[0][i-1] && dp[j+1][s.length()-1])
                return true;
            }
        }
        return false;
    }
}