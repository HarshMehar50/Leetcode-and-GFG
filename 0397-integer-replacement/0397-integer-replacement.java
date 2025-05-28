class Solution {
    int solve(long n , HashMap<Long , Integer> dp){
        if(n == 1){
            return 0;
        }
        if(n < 1){
            return Integer.MAX_VALUE;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int ans = 0;
        int includeOddAdd = 0;
        int includeOddSub = 0;
        if(n%2 == 0){
            ans = 1+solve(n/2 , dp);
        }else{
            includeOddAdd = solve(n+1 , dp);
            includeOddSub = solve(n-1 , dp);
            ans = 1+Math.min(includeOddSub , includeOddAdd);
        }
        dp.put(n , ans);
        return ans;
    }
    /*int solveTab(int n){
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i < n; i++){
             int includeEven = 0;
             int oddans = 0;
             if(i%2 == 0){
               includeEven = 1+dp[i/2];
            }else{
                oddans = 1+Math.min(dp[i+1] , dp[i-1]);
            }
        int ans = includeEven + oddans;
        dp[i] = ans;
        }
        return dp[n];
    }*/
    public int integerReplacement(int n) {
        HashMap<Long , Integer> dp = new HashMap<>();
        return solve((long)n , dp);
        //return solve(n);
    }
}