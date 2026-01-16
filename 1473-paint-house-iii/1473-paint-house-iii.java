class Solution {
    int solve(int[] houses , int[][] cost , int m , int n , int target , int c , int i , int p , int[][][] dp){
        if(m <= i){
            if(c == target)
            return 0;
        }
        if(i < m && dp[c][i][p] != -1)
        return dp[c][i][p];
        int ans = (int)(1e9);
        if(i < m){
        if(houses[i] != 0){
            if(houses[i] != p){
                if(c+1 <= target)
                ans = Math.min(ans , solve(houses , cost , m , n , target , c+1 , i+1 , houses[i] , dp));
            }else
            ans = Math.min(ans , solve(houses , cost , m , n , target , c , i+1 , houses[i] , dp));
        }else{
            for(int j = 0; j < n; j++){
                if(j+1 != p){
                    if(c+1 <= target)
                    ans = Math.min(ans , cost[i][j]+solve(houses , cost , m , n , target , c+1 , i+1 , j+1 , dp));
                }else
                ans = Math.min(ans , cost[i][j]+solve(houses , cost , m , n , target , c , i+1 , j+1 , dp));
            }
        }
        }
        if(i < m){
        dp[c][i][p] = ans;
        return dp[c][i][p];
        } 
        return (int)(1e9);
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[target+1][m][n+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        int ans = solve(houses , cost , m , n , target , 0 , 0 , 0 , dp);
        if(ans == (int)(1e9))
        return -1;
        return ans;
    }
}