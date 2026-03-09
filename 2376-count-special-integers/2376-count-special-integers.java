class Solution {
    int solve(String s , int i , int t , int mask , int start , int[][][][] dp){
        if(i >= s.length())
        return 1;
        if(dp[i][t][mask][start] != -1)
        return dp[i][t][mask][start];
        int ans = 0;
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            if((mask&(1<<j)) == 0) continue;
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(start == 0 && j == 0)
            ans += solve(s , i+1 , nt , mask , 0 , dp);
            else
            ans += solve(s , i+1 , nt , mask^(1<<j) , 1 , dp);
        }
        dp[i][t][mask][start] = ans;
        return dp[i][t][mask][start];
    }
    public int countSpecialNumbers(int n) {
        String s = Integer.toString(n);
        int[][][][] dp = new int[s.length()][2][(1<<10)][2];
        for(int[][][] a : dp){
            for(int[][] b : a){
                for(int[] c : b){
                    Arrays.fill(c , -1);
                }
            }
        }
        return solve(s , 0 , 0 , (1<<10)-1 , 0 , dp)-1;
    }
}