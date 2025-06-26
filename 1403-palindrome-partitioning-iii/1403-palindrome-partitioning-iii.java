class Solution {
    int calculate(String s , int l , int r){
        int ans = 0;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
                ans++;
            l++;
            r--;
        }
        return ans;
    }
    int solve(int[][] min , String s , int i , int k , int[][] dp){
        if(k == 0 && i == s.length())
            return 0;
        if(k < 0)
            return (int)1e9;
        if(dp[i][k] != -1)
            return dp[i][k];
        int ans = (int)1e9;
        for(int j = i; j < s.length(); j++){
            ans = Math.min(ans , min[i][j]+solve(min , s , j+1 , k-1 , dp));
        }
        dp[i][k] = ans;
        return dp[i][k];
    }
    public int palindromePartition(String s, int k) {
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
        int[][] min = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(!dp[i][j])
                    min[i][j] = calculate(s , i , j);
            }
        }
        int[][] finalDP = new int[s.length()+1][k+1];
        for(int i = 0; i < finalDP.length; i++){
            Arrays.fill(finalDP[i] , -1);
        }
        return solve(min , s , 0 , k , finalDP);
    }
}