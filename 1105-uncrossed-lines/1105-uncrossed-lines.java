class Solution {
    int solve(int[] nums1 , int[] nums2 , int i , int j , int[][] dp){
        if(i >= nums1.length || j >= nums2.length)
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];
        if(nums1[i] == nums2[j])
        return 1+solve(nums1 , nums2 , i+1 , j+1 , dp);
        else{
            int m1 = solve(nums1 , nums2 , i+1 , j , dp);
            int m2 = solve(nums1 , nums2 , i , j+1 , dp);
            int ans = Math.max(m1 , m2);
            dp[i][j] = ans;
            return dp[i][j];
        }
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums1 , nums2 , 0 , 0 , dp);
    }
}