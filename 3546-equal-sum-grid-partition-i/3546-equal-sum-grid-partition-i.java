class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long[][] ps = new long[grid.length][grid[0].length];
        ps[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            ps[i][0] = ps[i-1][0]+(long)grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            ps[0][i] = ps[0][i-1]+(long)grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                ps[i][j] = ps[i-1][j]+ps[i][j-1]+(long)grid[i][j]-ps[i-1][j-1];
            }
        }
        for(int i = 0; i < grid[0].length; i++){
            if(1L*2*ps[ps.length-1][i] == ps[ps.length-1][ps[0].length-1])
                return true;
        }
        for(int i = 0; i < grid.length; i++){
            if(1L*2*ps[i][ps[0].length-1] == ps[ps.length-1][ps[0].length-1])
                return true;
        }
        return false;
    }
}