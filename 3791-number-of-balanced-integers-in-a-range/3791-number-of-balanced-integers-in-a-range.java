class Solution {
    long solve(String s , int i , int s1 , int t , long[][][] dp){
        if(i == s.length()){
            if(s1 == 0)
            return 1;
            else
            return 0;
        }
        if(dp[i][s1+200][t] != -1)
        return dp[i][s1+200][t];
        long ans = 0;
        if(t == 1){
            for(int j = 0; j <= 9; j++){
                if(i%2 == 0)
                ans += solve(s , i+1 , s1+j , t , dp);
                else
                ans += solve(s , i+1 , s1-j , t , dp);
            }
        }else{
            for(int j = 0; j <= s.charAt(i)-'0'; j++){
                if(j == s.charAt(i)-'0'){
                    if(i%2 == 0)
                    ans += solve(s , i+1 , s1+j , t , dp);
                    else
                    ans += solve(s , i+1 , s1-j , t , dp);
                }else{
                    if(i%2 == 0)
                    ans += solve(s , i+1 , s1+j , 1 , dp);
                    else
                    ans += solve(s , i+1 , s1-j , 1 , dp);
                }
            }
        }
        dp[i][s1+200][t] = ans;
        return dp[i][s1+200][t];
    }
    public long countBalanced(long low, long high) {
        String sh = Long.toString(high);
        long[][][] dph = new long[sh.length()][401][2];
        String sl = Long.toString(low-1);
        long[][][] dpl = new long[sl.length()][401][2];
        for(long[][] a : dph){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        for(long[][] a : dpl){
            for(long[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(sh , 0 , 0 , 0 , dph)-solve(sl , 0 , 0 , 0 , dpl);
    }
}