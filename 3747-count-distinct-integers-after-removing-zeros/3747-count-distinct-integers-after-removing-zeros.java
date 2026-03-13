class Solution {
    long solve(String s , int i , int t , int start , long[][][] dp){
        if(i >= s.length())
        return 1;
        if(dp[i][t][start] != -1)
        return dp[i][t][start];
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        int st = 0;
        if(start == 1)
        st = 1;
        long ans = 0;
        for(int j = st; j <= limit; j++){
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(start == 0 && j == 0)
            ans += solve(s , i+1 , nt , 0 , dp);
            else
            ans += solve(s , i+1 , nt , 1 , dp);
        }
        dp[i][t][start] = ans;
        return dp[i][t][start];
    }
    public long countDistinct(long n) {
        String s = Long.toString(n);
        long[][][] dp = new long[s.length()][2][2];
        for(long[][] a : dp){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(s , 0 , 0 , 0 , dp)-1;
    }
}