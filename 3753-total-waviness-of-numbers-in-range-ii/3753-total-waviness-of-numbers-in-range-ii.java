class Solution {
    long solveMain(String s , int i , int t , int p1 , int p2 , int dl , int c , long[][][][][][] dp){
        if(i == s.length())
        return c;
        if(dp[i][t][p1][p2][dl][c] != -1)
        return dp[i][t][p1][p2][dl][c];
        long ans = 0;
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(t == 1 || j < limit)
            nt = 1;
            int ndl = dl;
            if(dl != 0 || j != 0)
            ndl++;
            ndl = Math.min(ndl , 3);
            if(((p1 > j && p1 > p2)||(p1 < j && p1 < p2))&&(ndl == 3))
            ans += solveMain(s , i+1 , nt , j , p1 , ndl , c+1 , dp);
            else
            ans += solveMain(s , i+1 , nt , j , p1 , ndl , c , dp);
        }
        dp[i][t][p1][p2][dl][c] = ans;
        return dp[i][t][p1][p2][dl][c];
    }
    /*long solve(String s , int i , int t , int p1 , int p2 , int c){
        if(i == s.length())
        return c;
        long ans = 0;
        int limit = 9;
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(p1 != -1 && p2 != -1){
                if((p1 > p2 && p1 > j)||(p1 < p2 && p1 < j))
                ans += solve(s , i+1 , nt , j , p1 , c+1);
            }else
            ans += solve(s , i+1 , nt , j , p1 , c);
        }
        return ans;
    }*/
    long solve(long n){
        String s = Long.toString(n);
        long[][][][][][] dp = new long[s.length()][2][10][10][4][15];
        for(long[][][][][] a : dp){
            for(long[][][][] b : a){
                for(long[][][] c : b){
                    for(long[][] d : c){
                        for(long[] e : d){
                            Arrays.fill(e , -1);
                        }
                    }
                }
            }
        }
        return solveMain(s , 0 , 0 , 0 , 0 , 0 , 0 , dp);
    }
    public long totalWaviness(long num1, long num2) {
        return solve(num2)-solve(num1-1);
    }
}