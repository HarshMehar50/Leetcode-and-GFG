class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*int l = matrix.length;
        int n = l*l;
        if(k < n/2){
            return matrix[k/l][(k%l)-1];
        }else if(k > n/2){
            int nk = n-k;
            return matrix[l-1-(nk/l)][l-1-(nk%l)];
        }else if(k%l == 0){
            return matrix[k/l-1][l-1];
        }else{
            return -1;
        }*/
        int n = matrix.length;
        int[] a = new int[n*n];
        for(int i = 0; i < a.length; i++){
            a[i] = matrix[i/n][i%n];
        }
        Arrays.sort(a);
        return a[k-1];
    }
}