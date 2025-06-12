class Solution {
    int solve(String s){
        int[][] dp = new int[s.length()+1][s.length()+1];
        String r = "";
        for(int i = s.length()-1; i >= 0; i--){
            r += s.charAt(i);
        }
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
    public int maxProduct(String s) {
        int ans = 0;
        for(int mask = 1; mask < (1<<s.length())-1; mask++){
            String s1 = "";
            String s2 = "";
            for(int i = 0; i < s.length(); i++){
                if((mask&(1<<i)) != 0)
                s1 += s.charAt(i);
                else
                s2 += s.charAt(i);
            }
            int pl1 = solve(s1);
            int pl2 = solve(s2);
            ans = Math.max(ans , pl1*pl2);
        }
        return ans;
    }
}