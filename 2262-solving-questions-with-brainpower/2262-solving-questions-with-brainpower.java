class Solution {
    long solve(int[][] questions , int index , long[] dp){
        if(index >= questions.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        long include = questions[index][0]+solve(questions , index+questions[index][1]+1 , dp);
        long exclude = solve(questions , index+1 , dp);
        long ans = Math.max(include , exclude);
        dp[index] = ans;
        return dp[index];
    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        return solve(questions , 0 , dp);
    }
}