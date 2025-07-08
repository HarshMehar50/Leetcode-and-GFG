
class Solution {
    /*static boolean solve(int n , int x , int y , boolean t){
        if(n == 0)
        return false;
        boolean ans = false;
        if(n-1 >= 0)
        ans = ans||solve(n-1 , x , y , !t);
        if(n-x >= 0)
        ans = ans||solve(n-x , x , y , !t);
        if(n-y >= 0)
        ans = ans||solve(n-y , x , y , !t);
        return ans;
    }*/
    public static int findWinner(int n, int x, int y) {
        // code here
        /*if(solve(n , x , y , true))
        return 1;
        else
        return 0;*/
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        for(int i = 1; i <= n; i++){
            if(i-1 >= 0 && !dp[i-1])
            dp[i] = true;
            else if(i-x >= 0 && !dp[i-x])
            dp[i] = true;
            else if(i-y >= 0 && !dp[i-y])
            dp[i] = true;
            else
            dp[i] = false;
        }
        if(dp[n])
        return 1;
        else
        return 0;
    }
}
