class Solution {
   /* List<Integer> createList(int n){
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n/2; i++){
            l.add(i*i);
        }
        return l;
    }*/
    public int numSquares(int n) {
       int[] dp = new int[n+1];
       for(int i = 0; i < n+1; i++){
        dp[i] = Integer.MAX_VALUE;
       }
       dp[0] = 0;
       for(int i = 1; i < n+1; i++){
        for(int j = 1; j*j <= n; j++){
            if((i-j*j)>=0){
            dp[i] = Math.min(dp[i-j*j]+1 , dp[i]);
            }
        }
       }
       
       return dp[n];
       
    }
}