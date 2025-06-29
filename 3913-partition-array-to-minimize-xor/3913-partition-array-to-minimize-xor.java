class Solution {
    int solve(int[] nums , int[] pxor , int k , int l , int[][] dp){
        if(k == 1){
            if(l == 0) 
            return pxor[nums.length-1];
            return pxor[nums.length-1]^pxor[l-1];
        }
        if(dp[k][l] != -1)
        return dp[k][l];
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= nums.length-k; i++){
            int xor = 0;
            if(l != 0)
            xor = pxor[i]^pxor[l-1];
            else
            xor = pxor[i];
            int max = Math.max(xor , solve(nums , pxor , k-1 , i+1 , dp));
            ans = Math.min(ans , max);
        }
        dp[k][l] = ans;
        return dp[k][l];
    }
    public int minXor(int[] nums, int k) {
        int[] pxor = new int[nums.length];
        pxor[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pxor[i] = pxor[i-1]^nums[i];
        }
        int[][] dp = new int[k+1][nums.length];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums , pxor , k , 0 , dp);
    }
}