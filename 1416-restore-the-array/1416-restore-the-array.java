class Solution {
    final int mod = 1000000007;
    int solve(String s , int k ,int ml , int i , int[] dp){
        if(i == s.length())
        return 1;
        if(dp[i] != -1)
        return dp[i];
        int ans = 0;
        for(int j = i; j < Math.min(i+ml , s.length()); j++){
            if(s.charAt(i) != '0' && Long.parseLong(s.substring(i , j+1)) <= (long)k)
            ans = (ans+solve(s , k , ml , j+1 , dp))%mod;
        }
        dp[i] = ans;
        return dp[i];
    }
    public int numberOfArrays(String s, int k) {
        int ml = Integer.toString(k).length();
        int[] dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(s , k , ml , 0 , dp);
    }
}