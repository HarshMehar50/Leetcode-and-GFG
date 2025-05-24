class Solution {
    int solve(List<List<Integer>> triangle , int i , int j , int[][] dp){
        if(i >= triangle.size()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int same = (triangle.get(i)).get(j) + solve(triangle , i+1 , j , dp);
        int increment = (triangle.get(i)).get(j) + solve(triangle , i+1 , j+1 , dp);
        int ans = Math.min(same , increment);
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        /*int s = 0;
        for(List<Integer> list : triangle){
            Collections.sort(list);
            s += list.get(0);
        }
        return s;*/
       /* int[] dp = new int[triangle.size()];
        dp[0] = (triangle.get(0)).get(0);
        int s = 0;
        for(int i = 1; i < dp.length; i++){
            List<Integer> current = triangle.get(i);
            int j = (triangle.get(i-1)).indexOf(dp[i-1]);
            dp[i] = Math.min(current.get(j) , current.get(j+1));
            s += dp[i];
        }
        return s+dp[0];*/
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i = 0; i < triangle.size(); i++){
            for(int j = 0; j < triangle.size(); j++){
                dp[i][j] = -1;
            }
        }
        return solve(triangle , 0 , 0 , dp);
    }
}