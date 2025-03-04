class Solution {
    /*boolean solve(int n , int[] dp){
        if(n == 0)
        return true;
        if(dp[n] != -1){
            if(dp[n] == 1)
            return true;
            else
            return false;
        }
        boolean ans = false;
        for(int i = 0; Math.pow(3 , i) <= n; i++){
            ans = ans|solve(n-(int)Math.pow(3 , i) , dp);
        }
        if(ans)
        dp[n] = 1;
        else
        dp[n] = 0;
        return ans;
    }*/
    public boolean checkPowersOfThree(int n) {
        /*int[] dp = new int[n+1];
        Arrays.fill(dp , -1);
        return solve(n , dp);*/
        List<Integer> l = new ArrayList<>();
        while(n != 0){
            l.add(n%3);
            n = n/3;
        }
        if(l.contains(2))
        return false;
        else
        return true;
    }
}