class Solution {
    int solve(int r , int c , int[][] grid , int k){
        List<Integer> l = new ArrayList<>();
        for(int i = r; i < r+k; i++){
            for(int j = c; j < c+k; j++){
                if(!l.contains(grid[i][j]))
                l.add(grid[i][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        Collections.sort(l);
        for(int i = 0; i < l.size()-1; i++){
            if(l.get(i) != l.get(i+1))
            ans = Math.min(ans , Math.abs(l.get(i+1)-l.get(i)));
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        else
        return 0;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ans = new int[grid.length-k+1][grid[0].length-k+1];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                ans[i][j] = solve(i , j , grid , k);
            }
        }
        return ans;
    }
}