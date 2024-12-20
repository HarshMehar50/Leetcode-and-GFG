class Solution {
    /*int solve(int[] nums1 , int[] nums2 , int i , int j){
        if(i == nums1.length){
            return 0;
        }
        if(j == nums2.length){
            return 0;
        }
        if(i == j && nums1[i]*nums2[j] >= 0){
            return Math.max(nums1[i]*nums2[j]+solve(nums1 , nums2 , i+1 , j+1) , solve(nums1 , nums2 , i+1 , j+1));
        }else{
            return Math.max(solve(nums1, nums2 , i+1 , j) , solve(nums1 , nums2 , i , j+1));
        }
    }*/
    int solve(int[] nums1 , int[] nums2 , int i , int j , int[][] dp){
        if(i >= nums1.length || j >= nums2.length)
        return -1000000000;
        if(dp[i][j] != -1000000000)
        return dp[i][j];
        int same = solve(nums1 , nums2 , i+1 , j+1 , dp)+(nums1[i]*nums2[j]);
        int inc1 = solve(nums1 , nums2 , i+1 , j , dp);
        int inc2 = solve(nums1 , nums2 , i , j+1 , dp);
        int ans = Math.max(nums1[i]*nums2[j] , Math.max(same , Math.max(inc1 , inc2)));
        dp[i][j] = ans;
        return dp[i][j];
    }
    int solveTab(int[] nums1 , int[] nums2){
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1000000000);
        }
        for(int i = nums1.length-1; i >= 0; i--){
            for(int j = nums2.length-1; j >= 0; j--){
                dp[i][j] = Math.max(nums1[i]*nums2[j] , Math.max(dp[i+1][j+1]+(nums1[i]*nums2[j]) , Math.max(dp[i+1][j] , dp[i][j+1])));
            }
        }
        return dp[0][0];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        /*int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1000000000);
        }
        return solve(nums1 , nums2 , 0 , 0 , dp);*/
        return solveTab(nums1 , nums2);
    }
}