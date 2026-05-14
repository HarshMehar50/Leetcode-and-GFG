class Solution {
    public boolean isGood(int[] nums) {
        int[] f = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= f.length)
            return false;
            f[nums[i]]++;
        }
        for(int i = 1; i < nums.length-1; i++){
            if(f[i] != 1)
            return false;
        }
        if(f[nums.length-1] != 2)
        return false;
        return true;
    }
}