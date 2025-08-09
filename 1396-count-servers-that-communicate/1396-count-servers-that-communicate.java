class Solution {
    public int countServers(int[][] grid) {
        int[] r = new int[grid.length];
        int[] c = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && (r[i] > 1 || c[j] > 1))
                    ans++;
            }
        }
        return ans;
    }
}