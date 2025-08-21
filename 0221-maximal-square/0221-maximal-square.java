class Solution {
    int solve(char[][] matrix , int r , int c){
        if(r >= matrix.length || c >= matrix[0].length)
        return 0;
        if(matrix[r][c] == '0')
        return 0;
        int right = solve(matrix , r , c+1);
        int down = solve(matrix , r+1 , c);
        int daigonal = solve(matrix , r+1 , c+1);
        int ans = 1+Math.min(daigonal , Math.min(right , down));
        return ans;
    }
    public int maximalSquare(char[][] matrix) {
        int s = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                s = Math.max(s , solve(matrix , i , j));
            }
        }
        return s*s;
    }
}