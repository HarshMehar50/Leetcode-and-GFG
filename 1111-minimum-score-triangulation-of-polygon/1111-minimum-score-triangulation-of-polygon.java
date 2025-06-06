class Solution {
    /*int solvetab(int[] values){
        int[][] dp = new int[values.length][values.length];
        for(int i = 0; i < dp.length-1; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i+1 == j)
                dp[i][j] = 0;
            }
        }
        for(int i = )
    }*/
    int solve(int[] values , int i , int j , int[][] dp){
        if(i+1 == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            int x = values[i]*values[j]*values[k] + solve(values , i , k , dp) + solve(values , k , j , dp);
            ans = Math.min(ans , x);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(values , 0 , values.length-1 , dp);
    }
}