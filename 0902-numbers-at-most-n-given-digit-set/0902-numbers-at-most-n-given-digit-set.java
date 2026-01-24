class Solution {
    int solve(String s , int[] digits , int i , int t , int[][] dp){
        if(i == s.length())
        return 1;
        if(dp[i][t] != -1)
        return dp[i][t];
        int ans = 0;
        int limit = digits[digits.length-1];
        if(t == 0)
        limit = s.charAt(i)-'0';
        for(int j = 0; j < digits.length && digits[j] <= limit; j++){
            int nt = 0;
            if(digits[j] < limit || t == 1)
            nt = 1;
            ans += solve(s , digits , i+1 , nt , dp);
        }
        dp[i][t] = ans;
        return dp[i][t];
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] d = new int[digits.length];
        for(int i = 0; i < digits.length; i++){
            d[i] = Integer.parseInt(digits[i]);
        }
        Arrays.sort(d);
        String s = Integer.toString(n);
        int[][] dp = new int[s.length()][2];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        int ans = solve(s , d , 0 , 0 , dp);
        for(int i = 1; i < s.length(); i++){
            ans += Math.pow(digits.length , i);
        }
        return ans;
    }
}