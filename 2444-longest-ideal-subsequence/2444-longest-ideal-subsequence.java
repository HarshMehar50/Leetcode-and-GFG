class Solution {
    int solve(String s , int k , int i , int pv , int[][] dp){
        if(i >= s.length())
        return 0;
        if(dp[i][pv+1] != -1)
        return dp[i][pv+1];
        int include = 0;
        if(pv == -1 || (pv != -1 && Math.abs((int)(s.charAt(i)-'a')-pv) <= k))
        include = 1+solve(s , k , i+1 , (int)(s.charAt(i)-'a') , dp);
        int exclude = solve(s , k , i+1 , pv , dp);
        int ans = Math.max(include , exclude);
        dp[i][pv+1] = ans;
        return dp[i][pv+1];
    }
    public int longestIdealString(String s, int k) {
        int[][] dp = new int[s.length()][27];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(s , k , 0 , -1 , dp);
    }
}