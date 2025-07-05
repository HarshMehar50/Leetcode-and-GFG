class Solution {
    int solve(int[] satisfaction , int index , int time , int[][] dp){
        if(index >= satisfaction.length){
            return 0;
        }
        if(dp[index][time] != -1){
            return dp[index][time];
        }
        int include = satisfaction[index]*(time+1)+solve(satisfaction , index+1 , time+1 , dp);
        int exclude = solve(satisfaction , index+1 , time , dp);
        int ans = Math.max(include , exclude);
        dp[index][time] = ans;
        return dp[index][time];
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length][satisfaction.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(satisfaction , 0 , 0 , dp);
    }
}