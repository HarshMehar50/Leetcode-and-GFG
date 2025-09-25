class Solution {
    int solve(List<List<Integer>> triangle , int i , int j , int[][] dp){
        if(i >= triangle.size() || j >= triangle.get(i).size())
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        int same = triangle.get(i).get(j) + solve(triangle , i+1 , j , dp);
        int increment = triangle.get(i).get(j) + solve(triangle , i+1 , j+1 , dp);
        int ans = Math.min(same , increment);
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        /*for(int i = 0; i < triangle.size(); i++){
            for(int j = 0; j < triangle.size(); j++){
                dp[i][j] = -1;
            }
        }
        return solve(triangle , 0 , 0 , dp);*/
        for(int i = 0; i < triangle.get(triangle.size()-1).size(); i++){
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i = triangle.size()-2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i+1][j] , dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}