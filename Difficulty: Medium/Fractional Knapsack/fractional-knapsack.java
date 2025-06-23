class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        double[][] a = new double[values.length][3];
        for(int i = 0; i < a.length; i++){
            a[i][0] = values[i];
            a[i][1] = weights[i];
            a[i][2] = (double)((double)values[i]/(double)weights[i]);
        }
        Arrays.sort(a , (x , y)->Double.compare(y[2] , x[2]));
        double ans = 0;
        for(int i = 0; i < a.length; i++){
            if(W > 0){
                ans += Math.min(W , a[i][1])*a[i][2];
                W = W-Math.min(W , (int)a[i][1]);
            }
        }
        return ans;
    }
}