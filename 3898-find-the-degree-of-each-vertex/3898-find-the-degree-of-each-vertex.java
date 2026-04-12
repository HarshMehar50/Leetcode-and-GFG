class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] ans = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    ans[i]++;
                    ans[j]++;
                }
            }
        }
        return ans;
    }
}