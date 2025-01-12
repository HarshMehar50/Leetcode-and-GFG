class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        if(grid[0].length%2 == 0){
            for(int i = 0; i < grid.length; i++){
                if(i%2 == 0){
                    for(int j = 0; j < grid[0].length; j=j+2){
                        ans.add(grid[i][j]);
                    }
                }else{
                    for(int j = grid[0].length-1; j >= 0; j=j-2){
                        ans.add(grid[i][j]);
                    }
                }
            }
        }else{
            for(int i = 0; i < grid.length; i++){
                if(i%2 == 0){
                    for(int j = 0; j < grid[0].length; j=j+2){
                        ans.add(grid[i][j]);
                    }
                }else{
                    for(int j = grid[0].length-2; j >= 0; j=j-2){
                        ans.add(grid[i][j]);
                    }
                }
            }
        }
        return ans;
    }
}