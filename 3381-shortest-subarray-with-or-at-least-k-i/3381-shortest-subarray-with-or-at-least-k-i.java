class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        for(int l = 1; l <= nums.length; l++){
            for(int i = 0; i+l-1 < nums.length; i++){
                int or = 0;
                for(int j = i; j < i+l; j++){
                    or = or|nums[j];
                }
                if(or >= k)
                return l;
            }
        }
        return -1;
    }
}