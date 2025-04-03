class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] pm = new int[nums.length];
        int[] sm = new int[nums.length];
        pm[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pm[i] = Math.max(pm[i-1] , nums[i]);
        }
        sm[sm.length-1] = nums[nums.length-1];
        for(int i = sm.length-2; i >= 0; i--){
            sm[i] = Math.max(sm[i+1] , nums[i]);
        } 
        long ans = 0;
        for(int i = 1; i < nums.length-1; i++){
            ans = Math.max(ans , (long)(((long)pm[i-1]-(long)nums[i])*(long)sm[i+1]));
        }
        return ans;
    }
}