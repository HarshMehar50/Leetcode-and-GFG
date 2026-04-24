class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] psmax = new int[nums.length];
        int[] ssmin = new int[nums.length];
        psmax[0] = nums[0];
        ssmin[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            psmax[i] = Math.max(psmax[i-1] , nums[i]);
        }
        for(int i = nums.length-2; i >= 0; i--){
            ssmin[i] = Math.min(ssmin[i+1] , nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(psmax[i]-ssmin[i] <= k)
            return i;
        }
        return -1;
    }
}