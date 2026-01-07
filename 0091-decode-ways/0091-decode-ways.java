class Solution {
    List<String> l;
    boolean valid(String s , int s1 , int e){
        return l.contains(s.substring(s1 , e+1));
    }
    int solve(String s , int i , int[] dp){
        if(i >= s.length())
        return 1;
        if(dp[i] != -1)
        return dp[i];
        int ans = 0;
        for(int j = i; j < s.length(); j++){
            if(valid(s , i , j))
            ans = ans+solve(s , j+1 , dp);
        }
        dp[i] = ans;
        return dp[i];
    }
    public int numDecodings(String s) {
        l = new ArrayList<>();
        for(int i = 1; i <= 26; i++){
            l.add(Integer.toString(i));
        }
        int[] dp= new int[s.length()];
        Arrays.fill(dp , -1);
        return solve(s , 0 , dp);
    }
}