class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        /*long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        long ans = -(long)1e15;*/
        /*for(int l = k; l <= nums.length; l += k){
            for(int i = 0; i+l-1 < nums.length; i++){
                long ss = 0;
                if(i == 0)
                ss = ps[i+l-1];
                else
                ss = ps[i+l-1]-ps[i-1];
                ans = Math.max(ans , ss);
            }
        }*/
        /*long[] psmin = new long[k];
        Arrays.fill(psmin , (long)1e15);
        psmin[0] = 0;
        for(int i = 0; i < nums.length; i++){
            psmin[(i+1)%k] = Math.min(psmin[(i+1)%k] , ps[i]);
        }
        for(int i = 0; i < nums.length; i++){
        
            ans = Math.max(ans , ps[i]-psmin[(i+1)%k]);
        }
        return ans;*/
        long ans = -(long)1e16;
        long[] ps = new long[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            ps[i+1] = ps[i]+nums[i];
        }
        long[] psmin = new long[k];
        Arrays.fill(psmin , (long)1e16);
        psmin[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            if(psmin[i%k] != (long)1e16)
            ans = Math.max(ans , ps[i]-psmin[i%k]);
            psmin[i%k] = Math.min(ps[i] , psmin[i%k]);
        }
        return ans;
    }
}