class Solution {
    int solve(int[] piles , int start , int end){
        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < piles.length; i++){
            dp[i][i] = piles[i];
        }
        for(int sal = 2; sal <= piles.length; sal++){
            for(int i = 0; i <= piles.length-sal; i++){
                int j = i+sal-1;
                dp[i][j] = Math.max(piles[i]-dp[i+1][j] , piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][piles.length-1];
    }
    public boolean stoneGame(int[] piles) {
        int ans = solve(piles , 0 , piles.length-1);
        if(ans > 0)
            return true;
        else
            return false;
    }
}