class Solution {
    int solve(int[] obstacles , int cl , int cp , int[][] dp){
        if(cp == obstacles.length-1){
            return 0;
        }
        if(dp[cl][cp] != -1){
            return dp[cl][cp];
        }
        int ans = Integer.MAX_VALUE;
        if(obstacles[cp+1] != cl){
            return solve(obstacles , cl , cp+1 , dp);
        }else{
            for(int i = 1; i <= 3; i++){
                if(cl != i && obstacles[cp] != i)
                    ans = Math.min(ans , 1+solve(obstacles , i , cp , dp));
                dp[cl][cp] = ans;
            }
        }
        return dp[cl][cp];
    }
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[4][obstacles.length];
        for(int i = 0; i < 4; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(obstacles, 2 , 0 , dp);
    }
}