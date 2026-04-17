class Solution {
    /*int solve(List<List<Integer>> grid , int i , int j){
        if(i >= grid.size() || j >= grid.get(0).size())
        return Integer.MIN_VALUE;
        int right = 0;
        int down = 0;
        if(j+1 < grid.get(0).size())
        right = grid.get(i).get(j+1)-grid.get(i).get(j)+solve(grid , i , j+1);
        if(i+1 < grid.size())
        down = grid.get(i+1).get(j)-grid.get(i).get(j)+solve(grid , i+1 , j);
        int ans = Math.max(right , down);
        return ans;
    }*/
    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        /*for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid.get(0).size(); j++){
                ans = Math.max(ans , solve(grid , i , j));
            }
        }*/
        int[][] suffixMax = new int[grid.size()][grid.get(0).size()];
        for (int i = suffixMax.length-1; i >= 0; i--) {
            for (int j = suffixMax[0].length-1; j >= 0; j--) {
                int down = (i + 1 < suffixMax.length) ? suffixMax[i + 1][j] : Integer.MIN_VALUE;
                int right = (j + 1 < suffixMax[0].length) ? suffixMax[i][j + 1] : Integer.MIN_VALUE;
                int diag = (i + 1 < suffixMax.length && j + 1 < suffixMax[0].length) ? suffixMax[i + 1][j + 1] : Integer.MIN_VALUE;
                suffixMax[i][j] = Math.max(grid.get(i).get(j), Math.max(down, Math.max(right, diag)));
            }
        }
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid.get(0).size(); j++){
                if(i+1 < grid.size())
                ans = Math.max(ans , suffixMax[i+1][j]-grid.get(i).get(j));
                if(j+1 < grid.get(0).size())
                ans = Math.max(ans , suffixMax[i][j+1]-grid.get(i).get(j));
                if(i+1 < grid.size() && j+1 < grid.get(0).size())
                ans = Math.max(ans , suffixMax[i+1][j+1]-grid.get(i).get(j));
            }
        }
        return ans;
    }
}