class Solution {
    int solve(int[] piles , int i , int m , int t , int[][][] dp){
        if(i >= piles.length)
        return 0;
        if(dp[i][m][t] != -1)
        return dp[i][m][t];
        int ans = -1;
        if(t == 0)
        ans = Integer.MAX_VALUE;
        else
        ans = Integer.MIN_VALUE;
        int s = 0;
        for(int x = 1; x <= Math.min(2*m , piles.length-i); x++){
            s += piles[i+x-1];
            if(t == 1)
            ans = Math.max(ans , s+solve(piles , i+x , Math.max(m , x) , 0 , dp));
            else
            ans = Math.min(ans , solve(piles , i+x , Math.max(m , x) , 1 , dp));
        }
        /*if(t){
            int s = 0;
            for(int x = 1; x <= Math.min(2*m , piles.length-i); x++){
                s += piles[i+x-1];
                ans = Math.max(ans , s+solve(piles , i+x , Math.max(x , m) , !t , dp));
            }
        }else{
            for(int x = 1; x <= Math.min(2*m , piles.length-i); x++){
                ans = Math.min(ans , solve(piles , i+x , Math.max(x , m) , !t , dp));
            }
        }*/
        dp[i][m][t] = ans;
        return dp[i][m][t];
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length+1][piles.length+1][2];
        for(int[][] a : dp){
            for(int i = 0; i < a.length; i++){
                Arrays.fill(a[i] , -1);
            }
        }
        /*for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }*/
        return solve(piles , 0 , 1 , 1 , dp);
    }
}