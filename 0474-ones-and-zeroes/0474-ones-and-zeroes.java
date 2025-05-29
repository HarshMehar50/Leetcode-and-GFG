class Solution {
    int count(String s , char c){
        int f = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                f++;
        }
        return f;
    }
    int solve(int[][] a , int index , int m , int n){
        if(index >= a.length || (m == 0 && n == 0)){
            return 0;
        }
        if(a[index][0] > m || a[index][1] > n){
            return solve(a , index+1 , m , n);
        }
        int include = 1+solve(a , index+1 , m-a[index][0] , n-a[index][1]);
        int exclude = solve(a , index+1 , m , n);
        int ans = Math.max(include  , exclude);
        return ans;
    }
    int solveTab(String[] strs, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for(String s : strs){
            int z = 0;
            int o = 0;
            for(char c : s.toCharArray())
                if(c == '0')
                    z++;
                else
                    o++;
            for(int i = m; i >= z; i--)
                for(int j = n; j >= o; j--)
                    dp[i][j] = Math.max(1+dp[i-z][j-o] , dp[i][j]);

        }
        return dp[m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] a = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            a[i][0] = count(strs[i] , '0');
            a[i][1] = strs[i].length()-a[i][0];
        }

        //return solve(a , 0 , m , n);
        return solveTab(strs , m , n);
    }
}