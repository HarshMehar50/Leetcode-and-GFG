class Solution {
    public long maximumProduct(int[] nums, int m) {
        long ans = -(long)(1e12);
        /*if(m == 1){
            for(int i = 0; i < nums.length; i++){
                ans = Math.max(ans , (long)((long)nums[i]*(long)nums[i]));
            }
        }else{
            for(int i = 0; i+m-1 < nums.length; i++){
                for(int j = i+m-1; j < nums.length; j++){
                    ans = Math.max(ans , (long)((long)nums[i]*(long)nums[j]));
                }
            }
        }
        return ans;*/
        long[] smin = new long[nums.length];
        long[] smax = new long[nums.length];
        smin[smin.length-1] = nums[nums.length-1];
        smax[smax.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            smin[i] = Math.min(smin[i+1] , nums[i]);
            smax[i] = Math.max(smax[i+1] , nums[i]);
        }
        for(int i = 0; i+m-1 < nums.length; i++){
            ans = Math.max(ans , Math.max((long)((long)nums[i]*smin[i+m-1]) , (long)((long)nums[i]*smax[i+m-1])));
        }
        return ans;
    }
}