class Solution {
    int solve(String s1 , String s2 , String s3 , int i , int j , int k , int[][][] dp){
        if(i >= s1.length() || j >= s2.length() || k >= s3.length())
        return 0;
        if(dp[i][j][k] != -1)
        return dp[i][j][k];
        if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k))
        return solve(s1 , s2 , s3 , i+1 , j+1 , k+1 , dp)+1;
        else{
            int m1 = solve(s1 , s2 , s3 , i+1 , j , k , dp);
            int m2 = solve(s1 , s2 , s3 , i , j+1 , k , dp);
            int m3 = solve(s1 , s2 , s3 , i , j , k+1 , dp);
            dp[i][j][k] = Math.max(m1 , Math.max(m2 , m3));
            return dp[i][j][k];
        }
    }
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        int[][][] dp = new int[s1.length()][s2.length()][s3.length()];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b , -1);
            }
        }
        return solve(s1 , s2 , s3 , 0 , 0 , 0 , dp);
    }
}