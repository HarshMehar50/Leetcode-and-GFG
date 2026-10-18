class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int r = 0;
        int c = 0;
        while(true){
            visited[r][c] = true;
            int nr = r;
            int nc = c;
            if(grid[r][c] == 'R')
            nc++;
            else if(grid[r][c] == 'L')
            nc--;
            else if(grid[r][c] == 'U')
            nr--;
            else
            nr++;

            if(nr >= grid.length || nr < 0 || nc < 0 || nc >= grid[0].length || (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && visited[nr][nc]))
            break;

            r = nr;
            c = nc;
        }
        return new int[]{r , c};
    }
}