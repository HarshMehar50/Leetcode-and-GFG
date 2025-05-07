class Solution {
    public int matrixScore(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < grid[0].length; j++){
                    grid[i][j] = 1-grid[i][j];
                }
            }
        }
        int[] c = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 0)
                    c[i]++;
            }
        }
        for(int i = 0; i < c.length; i++){
            if(c[i] > grid.length-c[i]){
                for(int j = 0; j < grid.length; j++){
                    grid[j][i] = 1-grid[j][i];
                }
            }
        }
        int ans = 0;
        int[] cs = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                cs[i] += grid[j][i];
            }
        }
        for(int i = 0; i < cs.length; i++){
            ans += cs[i]*(int)Math.pow(2 , cs.length-1-i);
        }
        return ans;
    }
}