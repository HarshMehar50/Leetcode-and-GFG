class Solution {
    boolean solve(char[][] grid , int i , int j , int s , int[][][] dp){
        if(i == grid.length-1 && j == grid[0].length-1){
            if(s == 0)
            return true;
            else
            return false;
        }
        if(s >= 0 && dp[i][j][s] != -1){
            if(dp[i][j][s] == 1)
            return true;
            else
            return false;
        }
        boolean ans = false;
        int sr = 0;
        if(j+1 < grid[0].length){
            if(grid[i][j+1] == '(')
            sr++;
            else
            sr--;
            if(s+sr >= 0)
            ans |= solve(grid , i , j+1 , s+sr , dp);
        }
        int sc = 0;
        if(i+1 < grid.length){
            if(grid[i+1][j] == '(')
            sc++;
            else
            sc--;
            if(s+sc >= 0)
            ans |= solve(grid , i+1 , j , s+sc , dp);
        }
        if(s >= 0)
        if(ans)
        dp[i][j][s] = 1;
        else
        dp[i][j][s] = 0;
        if(s >= 0 && dp[i][j][s] == 1)
        return true;
        else
        return false;
    }
    public boolean hasValidPath(char[][] grid) {
        int sv = 0;
        if(grid[0][0] == '(')
        sv++;
        else
        sv--;
        int[][][] dp = new int[grid.length][grid[0].length][2*(Math.max(grid.length , grid[0].length)+1)];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(grid , 0 , 0 , sv , dp);
    }
}