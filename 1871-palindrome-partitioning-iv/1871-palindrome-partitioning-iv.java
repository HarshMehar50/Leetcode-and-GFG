class Solution {
    boolean check(String st , int s , int e){
        if(s == e)
        return true;
        while(s < e){
            if(st.charAt(s) != st.charAt(e))
            return false;
            s++;
            e--;
        }
        return true;
    }
    boolean solve(String s , int l , int r , int[][] dp){
        if(l > r)
        return false;
        if(check(s , 0 , l-1) && check(s , l , r) && check(s , r+1 , s.length()-1))
        return true;
        if(dp[l][r] != -1){
            if(dp[l][r] == 1)
            return true;
            else
            return false;
        }
        boolean ans = false;
        for(int i = l+1; i < r; i++){
            ans = ans|solve(s , i , r , dp);
        }
        for(int i = r-1; i >= l; i--){
            ans = ans|solve(s , l , i , dp);
        }
        if(ans)
        dp[l][r] = 1;
        else
        dp[l][r] = 0;
        return ans;
    }
    public boolean checkPartitioning(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(s , 1 , s.length()-2 , dp);
    }
}