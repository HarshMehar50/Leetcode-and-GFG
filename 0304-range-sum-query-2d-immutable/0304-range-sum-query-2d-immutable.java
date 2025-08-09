class NumMatrix {
    int[][] ps;
    public NumMatrix(int[][] matrix) {
        ps = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            ps[i][0] = matrix[i][0];
            if(i > 0)
            ps[i][0] += ps[i-1][0];
        }
        for(int i = 0; i < matrix[0].length; i++){
            ps[0][i] = matrix[0][i];
            if(i > 0)
            ps[0][i] += ps[0][i-1];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                ps[i][j] = matrix[i][j]+ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1];
            }
        }        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = ps[row2][col2];
        if(row1 > 0)
        ans -= ps[row1-1][col2];
        if(col1 > 0)
        ans -= ps[row2][col1-1];
        if(row1 > 0 && col1 > 0)
        ans += ps[row1-1][col1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */