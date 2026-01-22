class Solution {
    final int mod = 1000000007;
    int solve(String s , int min_sum , int max_sum , int i , int t , int ds , int[][][] dp){
        if(i == s.length()){
            if(ds >= min_sum && ds <= max_sum)
            return 1;
            else
            return 0;
        }
        if(dp[i][t][ds] != -1)
        return dp[i][t][ds];
        int ans = 0;
        if(t == 1){
            for(int j = 0; j <= 9; j++){
                ans = (ans+solve(s , min_sum , max_sum , i+1 , t , ds+j , dp))%mod;
            }
        }else{
            for(int j = 0; j <= s.charAt(i)-'0'; j++){
                if(j == s.charAt(i)-'0')
                ans = (ans+solve(s , min_sum , max_sum , i+1 , t , ds+j , dp))%mod;
                else
                ans = (ans+solve(s , min_sum , max_sum , i+1 , 1 , ds+j , dp))%mod;
            }
        }
        dp[i][t][ds] = ans;
        return dp[i][t][ds];
    }
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int e = 0;
        int s = 0;
        for(int i = 0; i < num1.length(); i++){
            s += num1.charAt(i)-'0';
        }
        if(s >= min_sum && s <= max_sum)
        e = 1;
        int[][][] dph = new int[num2.length()][2][200];
        for(int[][] a : dph){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        int[][][] dpl = new int[num2.length()][2][200];
        for(int[][] a : dpl){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        int ans = (solve(num2 , min_sum , max_sum , 0 , 0 , 0 , dph)-solve(num1 , min_sum , max_sum , 0 , 0 , 0 , dpl)+mod)%mod;
        ans = (ans+e)%mod;
        return ans;
    }
}