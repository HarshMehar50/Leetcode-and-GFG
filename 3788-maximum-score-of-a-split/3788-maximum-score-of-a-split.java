class Solution {
    public long maximumScore(int[] nums) {
        long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+(long)nums[i];
        }
        int[] sm = new int[nums.length];
        sm[sm.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            sm[i] = Math.min(sm[i+1] , nums[i]);
        }
        long ans = -(long)(1e15);
        for(int i = 0; i < nums.length-1; i++){
            ans = Math.max(ans , ps[i]-sm[i+1]);
        }
        return ans;
    }
}