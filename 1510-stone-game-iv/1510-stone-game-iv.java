class Solution {
    boolean solve(int n , int[] dp){
        /*if(n == 0){
            if(t == 0)
            return true;
            else
            return false;
        }
        boolean alice = false;
        boolean bob = false;
        if(t == 1){
            for(int i = 1; i*i <= n; i++){
                alice = alice||solve(n-(i*i) , 0);
            }
        }else{
            for(int i = 1; i*i <= n; i++){
                bob = bob||solve(n-(i*i) , 1);
            }
        }
        boolean ans = alice&&(!bob);
        return ans;*/
        if(n == 0)
        return false;
        if(dp[n] != -1){
            if(dp[n] == 1)
            return true;
            else
            return false;
        }
        for(int i = 1; i*i <= n; i++){
            if(!solve(n-(i*i) , dp)){
                dp[n] = 1;
                return true;
            }
        }
        dp[n] = 0;
        return false;
    }
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp);
    }
}