class Solution {
    public int getKth(int lo, int hi, int k) {
        int dp[][] = new int[hi-lo+1][2];
        for(int i = lo; i <= hi; i++){
            int c = 0;
            int x = i;
            while(x != 1){
                if(x%2 == 0){
                    x = x/2;
                }else{
                    x = (3*x) + 1;
                }
                c++;
            }
            dp[i-lo][0] = i;
            dp[i-lo][1] = c;
        }
        Arrays.sort(dp , (a , b)->a[1]-b[1]);
        return dp[k-1][0];
    }
}