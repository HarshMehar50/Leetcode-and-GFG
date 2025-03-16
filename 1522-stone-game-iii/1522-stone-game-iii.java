class Solution {
    int solve(int[] stoneValue , int i , int[] dp){
        if(i >= stoneValue.length)
        return 0;
        if(dp[i] != -1)
        return dp[i];
        int include1 = stoneValue[i]-solve(stoneValue , i+1 , dp);
        int include2 = Integer.MIN_VALUE;
        int include3 = Integer.MIN_VALUE;
        if(i+1 < stoneValue.length)
        include2 = stoneValue[i]+stoneValue[i+1]-solve(stoneValue , i+2 , dp);
        if(i+1 < stoneValue.length && i+2 < stoneValue.length)
        include3 = stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-solve(stoneValue , i+3 , dp);
        int ans = Math.max(include1 , Math.max(include2 , include3));
        dp[i] = ans;
        return dp[i];
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp , -1);
        int ans = solve(stoneValue , 0 , dp);
        if(ans > 0)
        return "Alice";
        else if(ans < 0)
        return "Bob";
        else
        return "Tie";
    }
}