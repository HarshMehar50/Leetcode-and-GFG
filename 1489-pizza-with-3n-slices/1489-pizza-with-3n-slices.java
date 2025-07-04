class Solution {
    int solve(int[] slices , int index , int start , int end  , int sum , int limit , int[][] dp){
        if(index > end || index < start || limit == 0){
            return sum;
        }
        if(dp[index][limit] != -1)
        return dp[index][limit];
        int include = solve(slices , index+2 , start , end , sum+slices[index] , limit-1 , dp);
        int exclude = solve(slices , index+1 , start , end , sum+0 , limit , dp);
        int ans = Math.max(include , exclude);
        dp[index][limit] = ans;
        return dp[index][limit];
    }
    int solveTab(int[] slices , int start , int end){
        int[][] dp = new int[slices.length+2][slices.length/3 + 1];
        for(int i = end ; i >= start; i--){
            for(int j = 1; j < slices.length/3 + 1; j++){
                dp[i][j] = Math.max(dp[i+1][j] ,slices[i]+dp[i+2][j-1]);
            }
        }
        return dp[start][slices.length/3];
    }
    public int maxSizeSlices(int[] slices) {
        /*int[][] dp = new int[slices.length+1][slices.length/3 + 1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int c1 = solve(slices , 0 , 0 ,slices.length-2 , 0 , slices.length/3 , dp);
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        int c2 = solve(slices , 1 , 1 ,slices.length-1 , 0 , slices.length/3 , dp);
        return Math.max(c1 , c2);*/
        int c1 = solveTab(slices , 0 , slices.length-2);
        int c2 = solveTab(slices , 1 , slices.length-1);
        return Math.max(c1 , c2);
    }
}