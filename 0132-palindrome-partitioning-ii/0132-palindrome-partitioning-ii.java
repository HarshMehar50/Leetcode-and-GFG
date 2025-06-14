class Solution {
    boolean check(String st , int s , int e){
        while(s < e){
            if(st.charAt(s) != st.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
    int solve(String s , int i , int[] dp){
        if(i >= s.length())
            return 0;
        if(dp[i] != -1)
            return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int j = i; j < s.length(); j++){
            if(check(s , i , j))
                ans = Math.min(ans , 1+solve(s , j+1 , dp));
        }
        dp[i] = ans;
        return dp[i];
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(s , 0 , dp)-1;
    }
}