class Solution {
    public String longestPalindrome(String s) {
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
        int maxLen = 0;
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(dp[i][j]){
                    if(maxLen <= Math.abs(j-i)+1){
                        maxLen = Math.abs(j-i)+1;
                        l = Math.min(i , j);
                        r = Math.max(i , j);
                    }
                }
            }
        }
        return s.substring(l , r+1);
    }
}