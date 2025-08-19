class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int c0 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
            c0++;
            else{
                ans += ((c0+1)*c0)/2;
                c0 = 0;
            }
        }
        ans += ((c0+1)*c0)/2;
        return ans;
    }
}