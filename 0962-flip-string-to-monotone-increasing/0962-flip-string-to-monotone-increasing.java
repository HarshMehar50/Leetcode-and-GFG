class Solution {
    int solve(String s , int p , int c , int[][] dp){
        if(c >= s.length())
            return 0;
        if(dp[c][p+1] != -1)
            return dp[c][p+1];
        int flip = Integer.MAX_VALUE;
        int noflip = Integer.MAX_VALUE;
        if(p == -1){
            if(s.charAt(c) == '1'){
                flip = 1+solve(s , 0 , c+1 , dp);
                noflip = solve(s , 1 , c+1 , dp);
            }else{
                flip = 1+solve(s , 1 , c+1 , dp);
                noflip = solve(s , 0 , c+1 , dp);
            }
        }else{
            if(s.charAt(c) == '0'){
                if(p == 1)
                    flip = 1+solve(s , 1 , c+1 , dp);
                else{
                    flip = 1+solve(s , 1 , c+1 , dp);
                    noflip = solve(s , 0 , c+1 , dp);
                }
            }else{
                if(p == 1)
                    noflip = solve(s , 1 , c+1 , dp);
                else{
                    flip = 1+solve(s , 0 , c+1 , dp);
                    noflip = solve(s , 1 , c+1 , dp);
                }
            }
        }
        int ans = Math.min(flip , noflip);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length()][3];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(s , -1 , 0 , dp);
    }
}