class Solution {
    int solve(String s , int k , int i , int t , int s1 , int r , int start , int[][][][][] dp){
        if(i == s.length()){
            if(s1 == 0 && r == 0 && start == 1)
            return 1;
            else
            return 0;
        }
        if(dp[i][t][s1+11][r][start] != -1)
        return dp[i][t][s1+11][r][start];
        int ans = 0;
        /*if(t == 1){
            for(int j = 0; j <= 9; j++){
                if(j%2 == 0)
                ans += solve(s , k , i+1 , t , s1+1 , ((r*10)+j)%k);
                else
                ans += solve(s , k , i+1 , t , s1-1 , ((r*10)+j)%k);
            }
        }else{
            for(int j = 0; j <= s.charAt(i)-'0'; j++){
                if(j == s.charAt(i)-'0'){
                    if(j%2 == 0)
                    ans += solve(s , k , i+1 , t , s1+1 , ((r*10)+j)%k);
                    else
                    ans += solve(s , k , i+1 , t , s1-1 , ((r*10)+j)%k);
                }else{
                    if(j%2 == 0)
                    ans += solve(s , k , i+1 , 1 , s1+1 , ((r*10)+j)%k);
                    else
                    ans += solve(s , k , i+1 , 1 , s1-1 , ((r*10)+j)%k);
                }
            }
        }*/
        int limit = 9;
        if(t != 1)
        limit = s.charAt(i)-'0';
        for(int j = 0; j <= limit; j++){
            int nt = 0;
            if(j < limit || t == 1)
            nt = 1;
            if(start == 0 && j == 0)
            ans += solve(s , k , i+1 , nt , s1 , r , 0 , dp);
            else{
                if(j%2 == 0)
                ans += solve(s , k , i+1 , nt , s1+1 , ((r*10)+j)%k , 1 , dp);
                else
                ans += solve(s , k , i+1 , nt , s1-1 , ((r*10)+j)%k , 1 , dp);
            }
        }
        dp[i][t][s1+11][r][start] = ans;
        return dp[i][t][s1+11][r][start];
    }
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String sh = Integer.toString(high);
        int[][][][][] dph = new int[sh.length()][2][23][k][2];
        String sl = Integer.toString(low-1);
        int[][][][][] dpl = new int[sl.length()][2][23][k][2];
        for(int[][][][] a : dph){
            for(int[][][] b : a){
                for(int[][] c : b){
                    for(int[] d : c){
                        Arrays.fill(d , -1);
                    }
                }
            }
        }
        for(int[][][][] a : dpl){
            for(int[][][] b : a){
                for(int[][] c : b){
                    for(int[] d : c){
                        Arrays.fill(d , -1);
                    }
                }
            }
        }
        return solve(sh , k , 0 , 0 , 0 , 0 , 0 , dph)-solve(sl , k , 0 , 0 , 0 , 0 , 0 , dpl);
    }
}