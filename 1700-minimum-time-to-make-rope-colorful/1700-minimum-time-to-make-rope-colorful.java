class Solution {
    int solve(String colors , int[] neededTime , int c , int p , int[][] dp){
        if(c >= colors.length())
        return 0;
        if(dp[c][p+1] != -1)
        return dp[c][p+1];
        int include = Integer.MAX_VALUE;
        if(p == -1 || (p != -1 && colors.charAt(c) != colors.charAt(p)))
        include = solve(colors , neededTime , c+1 , c , dp);
        int exclude = neededTime[c]+solve(colors , neededTime , c+1 , p , dp);
        int ans = Math.min(include , exclude);
        dp[c][p+1] = ans;
        return dp[c][p+1];
    }
    public int minCost(String colors, int[] neededTime) {
        /*int[][] dp = new int[colors.length()][colors.length()+1];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        return solve(colors , neededTime , 0 , -1 , dp);*/
        int min = neededTime[0];
        int ans = 0;
        for(int i = 1; i < colors.length(); i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                ans += Math.min(min , neededTime[i]);
                min = Math.max(min , neededTime[i]);
            }else
            min = neededTime[i];
        }
        return ans;
    }
}