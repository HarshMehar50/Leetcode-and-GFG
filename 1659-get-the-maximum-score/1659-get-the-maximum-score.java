class Solution {
    final int mod = 1000000007;
    long solve(int[] nums1 , int[] nums2 , int i , int g , long[][] dp){
        if(g == 1 && i >= nums1.length)
        return 0;
        if(g == 0 && i >= nums2.length)
        return 0;
        if(dp[i][g] != -1)
        return dp[i][g];
        long same = 0;
        long change = 0;
        if(g == 1){
            same = nums1[i]+solve(nums1 , nums2 , i+1 , 1 , dp);
            int bs = Arrays.binarySearch(nums2 , nums1[i]);
            if(bs >= 0 && bs < nums2.length)
            change = nums1[i]+solve(nums1 , nums2 , bs+1 , 0 , dp);
        }else{
            same = nums2[i]+solve(nums1 , nums2 , i+1 , 0 , dp);
            int bs = Arrays.binarySearch(nums1 , nums2[i]);
            if(bs >= 0 && bs < nums1.length)
            change = nums2[i]+solve(nums1 , nums2 , bs+1 , 1 , dp);
        }
        long ans = Math.max(same , change);
        dp[i][g] = ans;
        return dp[i][g];
    }
    public int maxSum(int[] nums1, int[] nums2) {
        long[][] dp1 = new long[Math.max(nums1.length , nums2.length)][2];
        long[][] dp2 = new long[Math.max(nums1.length , nums2.length)][2];
        for(long[] x : dp1){
            Arrays.fill(x , -1);
        }
        for(long[] x : dp2){
            Arrays.fill(x , -1);
        }
        return (int)Math.max(solve(nums1 , nums2 , 0 , 1 , dp1)%mod , solve(nums1 , nums2 , 0 , 0 , dp2)%mod);
    }
}