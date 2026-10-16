class Solution {
    int solve(List<Integer> l , int i , int s , int[][] dp){
        if(i >= l.size()){
            if(s == 0)
            return 0;
            else
            return 1000000;
        }
        if(dp[i][s] != -1)
        return dp[i][s];
        int include = 1000000;
        if(l.get(i) <= s)
        include = 1+solve(l , i+1 , s-l.get(i) , dp);
        int exclude = solve(l , i+1 , s , dp);
        int ans = Math.min(include , exclude);
        dp[i][s] = ans;
        return dp[i][s];
    }
    public List<Integer> maxPrimeSubset(int n, int s) {
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= n; i++){
            if(p[i] && (long)i*(long)i <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(p[i])
            l.add(i);
        }
        boolean[][] dp = new boolean[l.size()][s+1];
        for(int i = 0; i < l.size(); i++){
            dp[i][0] = true;
        }
        if(l.size() > 0 && l.get(0) <= s)
        dp[0][l.get(0)] = true;
        for(int i = 1; i < l.size(); i++){
            for(int j = 1; j <= s; j++){
                boolean exclude = dp[i-1][j];
                boolean include = false;
                if(l.get(i) <= j)
                include = dp[i-1][j-l.get(i)];
                dp[i][j] = include||exclude;
            }
        }
        int las = -1;
        for(int i = s; i >= 0; i--){
            for(int j = 0; j < dp.length; j++){
                if(dp[j][i]){
                    las = i;
                    break;
                }
            }
            if(las != -1)
            break;
        }
        if(las == -1)
        return new ArrayList<>();
        int[][] dp1 = new int[l.size()+1][las+1];
        for(int[] a : dp1){
            Arrays.fill(a , -1);
        }
        int minSteps = solve(l , 0 , las , dp1);
        List<Integer> ans = new ArrayList<>();
        int rs = las;
        int rc = minSteps;
        for(int i = 0; i < l.size(); i++){
            if(rs >= l.get(i) && dp1[i+1][rs-l.get(i)] == rc-1){
                ans.add(l.get(i));
                rs -= l.get(i);
                rc--;
            }
        }
        if(rs != 0)
        ans.add(rs);
        return ans;
    }
}