class Solution {
    boolean check(int[][] mat , int r , int c){
        for(int i = 0; i < mat[0].length; i++){
            if(mat[r][i] != 0 && i != c)
            return false;
        }
        for(int i = 0; i < mat.length; i++){
            if(mat[i][c] != 0 && i != r)
            return false;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1 && check(mat , i , j))
                ans++;
            }
        }
        return ans;
    }
}