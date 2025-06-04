class Solution {
    int solve(int[] days, int[] costs , int index , int[] dp){
        if(index >= days.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int include0 = costs[0]+solve(days , costs , index+1 , dp);
        int i = 0;
        for(i = index; i < days.length &&days[i] < days[index]+7; i++);
        int include1 = costs[1]+solve(days , costs , i , dp);
        for(i = index; i < days.length && days[i] < days[index]+30; i++);
        int include2 = costs[2]+solve(days , costs , i , dp);
        int ans = Math.min(include0 , Math.min(include1 , include2));
        dp[index] = ans;
        return dp[index];
    }
    int solveTab(int[] days, int[] costs){
        int[] dp = new int[days.length];
        for(int j = dp.length-1; j >= 0; j--){
            int include0 = costs[0]+dp[j-1];
            int i = 0;
            for(i = j; i < days.length &&days[i] < days[j]-7; i--);
            int include1 = costs[1]+dp[i];
            for(i = j; i < days.length && days[i] < days[j]-30; i--);
            int include2 = costs[2]+dp[i];
            dp[j] = Math.min(include0 , Math.min(include1 , include2));
        }
        return dp[0];
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp , -1);
        return solve(days , costs , 0 , dp);
        //return solveTab(days , costs);
    }
}