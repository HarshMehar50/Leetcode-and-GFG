class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] ans = new int[grid.length][grid[0].length];
        for(int i = 0; i < ans.length; i++){
            Arrays.fill(ans[i] , -1);
        }
        for(int i = x; i < Math.min(x+k , ans.length); i++){
            for(int j = y; j < Math.min(y+k , ans[0].length); j++){
                ans[i][j] = grid[Math.min(x+k , ans.length)-1-(i-x)][j];
            }
        }
        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(ans[i][j] == -1)
                    ans[i][j] = grid[i][j];
            }
        }
        return ans;
    }
}