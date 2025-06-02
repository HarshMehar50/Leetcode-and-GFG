class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int p = 1;
        int ans = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            p = p*nums[r];
            while(l <= r && p >= k){
                ans += nums.length-r;
                p = p/nums[l];
                l++;
            }
        }
        return (nums.length*(nums.length+1))/2 - ans;
    }
}