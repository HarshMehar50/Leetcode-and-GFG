class Solution {
    int solve(int[][] coins , int i , int j , int k , int[][][] dp){
        if(i >= coins.length || j >= coins[0].length)
        return (int)(-1e9);
        if(i == coins.length-1 && j == coins[0].length-1){
            if(k > 0 && coins[i][j] < 0)
            return 0;
            else
            return coins[i][j];
        }
        if(dp[i][j][k] != (int)(-1e9))
        return dp[i][j][k];
        int rightp = (int)(-1e9);
        int downp = (int)(-1e9);
        int rightc = (int)(-1e9);
        int downc = (int)(-1e9);
        if(coins[i][j] >= 0){
            rightp = coins[i][j]+solve(coins , i , j+1 , k , dp);
            downp = coins[i][j]+solve(coins , i+1 , j , k , dp);
        }
        if(coins[i][j] < 0){
            if(k > 0){
            rightc = solve(coins , i , j+1 , k-1 , dp);
            downc = solve(coins , i+1 , j , k-1 , dp);
            }
            rightc = Math.max(rightc , coins[i][j]+solve(coins , i+1 , j , k , dp));
            downc = Math.max(downc , coins[i][j]+solve(coins , i , j+1 , k , dp));
        }
        int ans = Math.max(Math.max(rightp , downp) , Math.max(rightc , downc));
        dp[i][j][k] = ans;
        return dp[i][j][k];
    }
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];
        for(int i = 0; i < dp.length; i++){
            for(int[] a : dp[i]){
                Arrays.fill(a , (int)(-1e9));
            }
        }
        return solve(coins , 0 , 0 , 2 , dp);
    }
}