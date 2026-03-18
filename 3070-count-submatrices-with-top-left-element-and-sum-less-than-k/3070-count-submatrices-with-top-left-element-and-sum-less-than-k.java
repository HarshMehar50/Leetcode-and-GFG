class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] ps = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            ps[i][0] = grid[i][0];
            if(i > 0)
            ps[i][0] += ps[i-1][0];
        }
        for(int i = 0; i < grid[0].length; i++){
            ps[0][i] = grid[0][i];
            if(i > 0)
            ps[0][i] += ps[0][i-1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                ps[i][j] = grid[i][j]+ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(ps[i][j] <= k)
                ans++;
            }
        }
        return ans;
    }
}