class Solution {
    int solve(int[] arr , int d , int i , int[] dp){
        if(dp[i] != -1)
        return dp[i];
        int ans = 1;
        for(int j = 1; j <= d; j++){
            int ni = i+j;
            if(ni < arr.length && arr[ni] < arr[i])
            ans = Math.max(ans , 1+solve(arr , d , ni , dp));
            else
            break;
        }
        for(int j = 1; j <= d; j++){
            int ni = i-j;
            if(ni >= 0 && arr[ni] < arr[i])
            ans = Math.max(ans , 1+solve(arr , d , ni , dp));
            else
            break;
        }
        dp[i] = ans;
        return dp[i];
    }
    public int maxJumps(int[] arr, int d) {
        int ans = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp ,-1);
        for(int i = 0; i < arr.length; i++){
            if(dp[i] == -1)
            ans = Math.max(ans , solve(arr , d , i , dp));
            else
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }
}