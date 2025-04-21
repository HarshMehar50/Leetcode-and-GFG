class Solution {
    public int findPeakElement(int[] nums) {
        int m = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(m < nums[i]){
                m = nums[i];
                index = i;
            }
        }
        return index;
    }
}