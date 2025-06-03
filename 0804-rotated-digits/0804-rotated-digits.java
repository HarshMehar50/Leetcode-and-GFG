class Solution {
    public int rotatedDigits(int n) {
        /*if(n == 0 || n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3; i < dp.length; i++){
            if(goodInt(i))
            dp[i] = dp[i-1] + 1;
            else
            dp[i] = dp[i-1];
        }
        return dp[n];*/
        int x = 0;
        for(int i = 1; i <= n; i++){
            String s = Integer.toString(i);
            if(s.contains("3") || s.contains("4") || s.contains("7")){
                continue;
            }
            if(s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")){
                x++;
            }
        }
        return x;
    }
}