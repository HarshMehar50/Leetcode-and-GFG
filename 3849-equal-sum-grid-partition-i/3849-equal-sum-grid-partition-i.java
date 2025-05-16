class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int[][] ps = new int[grid.length][grid[0].length];
        ps[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            ps[i][0] = ps[i-1][0]+grid[i][0];
        }
        for(int i = 1; i < grid[0].length; i++){
            ps[0][i] = ps[0][i-1]+grid[0][i];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                ps[i][j] = ps[i-1][j]+ps[i][j-1]+grid[i][j]-ps[i-1][j-1];
            }
        }
        int t = ps[ps.length-1][ps[0].length-1];
        for(int i = 0; i < ps[0].length-1; i++){
            int l = ps[ps.length-1][i];
            int r = t-l;
            if(l == r)
            return true;
        }
        for(int i = 0; i < ps.length-1; i++){
            int u = ps[i][ps[0].length-1];
            int l = t-u;
            if(l == u)
            return true;
        }
        return false;
    }
}