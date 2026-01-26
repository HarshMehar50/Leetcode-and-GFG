class Solution {
    int solve(int num , int k , int s , int[][] dp){
        if(num == 0)
        return s;
        if(dp[num][s] != -1)
        return dp[num][s];
        int ans = Integer.MAX_VALUE;
        for(int i = k; i <= num; i += 10){
            if(i != 0)
            ans = Math.min(ans , solve(num-i , k , s+1 , dp));
        }
        dp[num][s] = ans;
        return dp[num][s];
    }
    public int minimumNumbers(int num, int k) {
        int[][] dp = new int[num+1][3001];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        int ans = solve(num , k , 0 , dp);
        if(ans == Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}