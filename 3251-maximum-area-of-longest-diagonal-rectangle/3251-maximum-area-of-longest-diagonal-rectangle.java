class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int[][] a = new int[dimensions.length][4];
        for(int i = 0; i < dimensions.length; i++){
            a[i][0] = dimensions[i][0];
            a[i][1] = dimensions[i][1];
            a[i][2] = (a[i][1]*a[i][1])+(a[i][0]*a[i][0]);
            a[i][3] = a[i][1]*a[i][0];
        }
        Arrays.sort(a , (x , y)->(x[2] != y[2])?Integer.compare(y[2] , x[2]):Integer.compare(y[3] , x[3]));
        return a[0][3];
    }
}