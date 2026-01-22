class Solution {
    int solve(String s , int n , int i , int t , int c1 , int[][][] dp){
        if(i == s.length())
        return c1;
        if(dp[i][t][c1] != -1)
        return dp[i][t][c1];
        int ans = 0;
        if(t == 1){
            for(int j = 0; j <= 9; j++){
                if(j == 1)
                ans += solve(s , n , i+1 , t , c1+1 , dp);
                else
                ans += solve(s , n , i+1 , t , c1 , dp);
            }
        }else{
            for(int j = 0; j <= s.charAt(i)-'0'; j++){
                if(j == s.charAt(i)-'0'){
                    if(j == 1)
                    ans += solve(s , n , i+1 , t , c1+1 , dp);
                    else
                    ans += solve(s , n , i+1 , t , c1 , dp);
                }else{
                    if(j == 1)
                    ans += solve(s , n , i+1 , 1 , c1+1 , dp);
                    else
                    ans += solve(s , n , i+1 , 1 , c1 , dp);
                }
            }
        }
        dp[i][t][c1] = ans;
        return dp[i][t][c1];
    }
    public int countDigitOne(int n) {
        String s = Integer.toString(n);
        int[][][] dp = new int[s.length()][2][11];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(s , n , 0 , 0 , 0 , dp);
    }
}