class Solution {
    void solve(String s , boolean[][] dp , int i , List<List<String>> ans , List<String> inner){
        if(i == s.length()){
            ans.add(new ArrayList<>(inner));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(dp[i][j]){
                inner.add(s.substring(i , j+1));
                solve(s , dp , j+1 , ans , inner);
                inner.remove(inner.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> inner = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int l = 1; l <= s.length(); l++){
            for(int i = 0; i+l-1 < s.length(); i++){
                int j = i+l-1;
                if(i == j)
                dp[i][j] = true;
                else if(i+1 == j && s.charAt(i) == s.charAt(j))
                dp[i][j] = true;
                else
                dp[i][j] = dp[i+1][j-1]&&(s.charAt(i) == s.charAt(j));
            }
        }
        solve(s , dp , 0 , ans , inner);
        return ans;
    }
}