class Solution {
    int solve(int[][] obstacleGrid  , int i  , int j , int[][] dp){
        if(obstacleGrid[0][0] == 1){
            return 0;
        }else{
            if(i == 0 && j == 0){
                return 1;
            }
            if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1){
                return 0;
            }
            if(i < 0 || j < 0){
                return 0;
            }
        }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
        /*int right = 0;
        int down = 0;
        if(obstacleGrid[i][j] == 0 && i < obstacleGrid.length && j < obstacleGrid[0].length){
            if(j+1 < obstacleGrid[0].length)
            right = solve(obstacleGrid , i , j-1);
            if(i+1 < obstacleGrid.length)
            down = solve(obstacleGrid , i-1 , j);
        }else{
            right = 0;
            down = 0;
        }*/
            int right = solve(obstacleGrid , i-1 , j , dp);
            int down = solve(obstacleGrid , i , j-1 , dp);
            int ans = right + down;
            dp[i][j] = ans;
            return dp[i][j];
        }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //return solve(obstacleGrid , 0 , 0);
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(obstacleGrid , obstacleGrid.length-1 , obstacleGrid[0].length-1 , dp);
    }
}