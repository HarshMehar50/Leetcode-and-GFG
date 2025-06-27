class Solution {
    public List<Integer> findCoins(int[] numWays) {
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[numWays.length+1];
        dp[0] = 1;
        for(int i = 0; i < numWays.length; i++){
            if(numWays[i]-dp[i+1] > 1 || numWays[i]-dp[i+1] < 0)
            return new ArrayList<>();
            if(numWays[i]-dp[i+1] != 0){
                ans.add(i+1);
                for(int j = i+1; j <= numWays.length; j++){
                    dp[j] += dp[j-(i+1)];
                }
            }
        }
        return ans;
    }
}