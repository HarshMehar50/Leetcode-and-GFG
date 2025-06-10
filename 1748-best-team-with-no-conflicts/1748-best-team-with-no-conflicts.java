class Solution {
    int solveTab(int[][] a){
        int[][] dp = new int[a.length+1][a.length+1];
        for(int i = a.length-1; i >= 0; i--){
            for(int j = i-1; j >= -1; j--){
                int include = 0;
                if(j == -1 || (a[i][1] >= a[j][1] && j != -1))
                    include = a[i][1]+dp[i+1][i+1];
                int exclude = dp[i+1][j+1];
                dp[i][j+1] = Math.max(include , exclude);
            }
        }
        return dp[0][0];
    }
    int solve(int[][] a , int c , int p , int[][] dp){
        if(c == a.length){
            return 0;
        }
        if(dp[c][p+1] != -1){
            return dp[c][p+1];
        }
        int include = 0;
        if(p == -1 || (a[c][1] >= a[p][1] && p != -1))
            include = a[c][1]+solve(a , c+1 , c , dp);
        int exclude = solve(a , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] a = new int[ages.length][2];
        for(int i = 0; i < a.length; i++){
            a[i][0] = ages[i];
            a[i][1] = scores[i];
        }
        /*int[][] dp = new int[ages.length][ages.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }*/
        Arrays.sort(a,(x , y)->(x[0] != y[0])?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1]));
        //return solve(a , 0 , -1 , dp);
        return solveTab(a);
    }
}