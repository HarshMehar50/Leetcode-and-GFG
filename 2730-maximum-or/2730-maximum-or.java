class Solution {
    public long maximumOr(int[] nums, int k) {
        long[] por = new long[nums.length];
        long[] sor = new long[nums.length];
        por[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            por[i] = por[i-1]|nums[i];
        }
        sor[sor.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            sor[i] = sor[i+1]|nums[i];
        }
        long f = (long)(1<<k);
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            long p = 0;
            long s = 0;
            if(i != 0)
            p = por[i-1];
            if(i != nums.length-1)
            s = sor[i+1];
            long nn = (long)((long)nums[i]*(long)f);
            ans = Math.max(ans , p|nn|s);
        }
        return ans;
    }
}