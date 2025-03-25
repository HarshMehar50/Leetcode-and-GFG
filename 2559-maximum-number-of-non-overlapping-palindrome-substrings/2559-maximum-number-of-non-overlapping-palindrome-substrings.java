class Solution {
    /*int solve(List<int[]> l , int c , int p , int[][] dp){
        if(c >= l.size())
        return 0;
        if(dp[c][p+1] != -1)
        return dp[c][p+1];
        int include = 0;
        if(p == -1 || (p != -1 && l.get(c)[0] > l.get(p)[1]))
        include = 1+solve(l , c+1 , c , dp);
        int exclude = solve(l , c+1 , p , dp);
        int ans = Math.max(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }*/
    int ceil(List<int[]> l , int t){
        int s = 0;
        int e = l.size();
        while(s < e){
            int m = s+(e-s)/2;
            if(l.get(m)[0] <= t)
            s = m+1;
            else
            e = m;
        }
        return s;
    }
    int solve(List<int[]> l , int i , int[] dp){
        if(i >= l.size())
        return 0;
        if(dp[i] != -1)
        return dp[i];
        int index = ceil(l , l.get(i)[1]);
        int include = 1+solve(l , index , dp);
        int exclude = solve(l , i+1 , dp);
        int ans = Math.max(include , exclude);
        dp[i] = ans;
        return dp[i];
    }
    public int maxPalindromes(String s, int k) {
        if(k == 1)
        return s.length();
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
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(j-i+1 >= k && dp[i][j])
                l.add(new int[]{i , j});
            }
        }
        Collections.sort(l , (x , y)->Integer.compare(x[0] , y[0]));
        /*int[][] dp1 = new int[l.size()][l.size()+1];
        for(int i = 0; i < dp1.length; i++){
            Arrays.fill(dp1[i] , -1);
        }
        return solve(l , 0 , -1 , dp1);*/
        int[] dp1 = new int[l.size()];
        Arrays.fill(dp1 , -1);
        return solve(l , 0 , dp1);
    }
}