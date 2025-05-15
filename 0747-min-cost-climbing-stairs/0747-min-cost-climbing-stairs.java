class Solution {
    int solve(int[] cost , int index){
        if(index >= cost.length){
            return 0;
        }
        /*if(dp[index] != Integer.MAX_VALUE){
            return dp[index];
        }*/
        int ans = cost[index]+Math.min(solve(cost , index+1) , solve(cost , index+2));
        //dp[index] = ans;
        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        /*int[] dp = new int[cost.length];
        Arrays.fill(dp , Integer.MAX_VALUE);*/
        return Math.min(solve(cost , 0) , solve(cost , 1));
    }
}