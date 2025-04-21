class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*int r = matrix.length;
        int c = matrix[0].length;
        int l = 0;
        int h = (r*c)-1;
        while(l <= h){
            int m = l + (h-l)/2;
            int tc = m%c;
            int tr = m/c;
            int val = matrix[tr][tc];
            if(val == target)
            return true;
            if(val < target)
            l = m+1;
            else;
            h = m-1;
        }
        return false;*/
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m*n];
        for(int i = 0; i < m*n; i++){
            a[i] = matrix[i/n][i%n];
        }
        int x = Arrays.binarySearch(a , target);
        if(x > -1)
            return true;
        else
            return false;
    }
}