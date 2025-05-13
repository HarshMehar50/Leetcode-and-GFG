class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] pxor = new int[nums.length];
        pxor[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pxor[i] = pxor[i-1]^nums[i];
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < ans.length; i++){
            int x = pxor[pxor.length-1-i];
            ans[i] = x^((1<<maximumBit)-1);
        }
        return ans;
    }
}