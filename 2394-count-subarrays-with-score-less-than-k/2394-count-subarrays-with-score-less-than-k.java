class Solution {
    public long countSubarrays(int[] nums, long k) {
        long s = 0;
        int l = 0;
        long ans = 0;
        for(int r = 0; r < nums.length; r++){
            s += nums[r];
            while(l <= r && (long)(s*(long)(r-l+1)) >= k){
                s -= nums[l];
                l++;
            }
            if((long)(s*(long)(r-l+1)) < k)
            ans += r-l+1;
        }
        return ans;
    }
}