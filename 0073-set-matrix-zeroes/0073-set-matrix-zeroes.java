class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> pz = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                pz.add(new int[]{i , j});
            }
        }
        for(int i = 0; i < pz.size(); i++){
            int r = pz.get(i)[0];
            int c = pz.get(i)[1];
            for(int j = 0; j < matrix[0].length; j++){
                matrix[r][j] = 0;
            }
            for(int j = 0; j < matrix.length; j++){
                matrix[j][c] = 0;
            }
        }
    }
}