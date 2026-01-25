class Solution {
    public int minimumPrefixLength(int[] nums) {
        int l = 0;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1])
                l++;
            else
                break;
        }
        l++;
        return nums.length-l;
    }
}