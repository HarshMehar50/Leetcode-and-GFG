class Solution {
    static boolean solve(int[] a , int i , int sum , int[][] dp){
        if(sum == 0)
        return true;
        if(i >= a.length){
            if(sum == 0)
            return true;
            else
            return false;
        }
        if(dp[i][sum] != -1){
            if(dp[i][sum] == 1)
            return true;
            else
            return false;
        }
        boolean include = false;
        if(sum-a[i] >= 0)
        include = solve(a , i+1 , sum-a[i] , dp);
        boolean exclude = solve(a , i+1 , sum , dp);
        boolean ans = include|exclude;
        if(ans)
        dp[i][sum] = 1;
        else
        dp[i][sum] = 0;
        return ans;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][] dp = new int[arr.length][sum+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(arr , 0 , sum , dp);
    }
}