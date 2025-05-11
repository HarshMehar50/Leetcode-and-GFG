class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int md = 0;
        for(int i = 0; i < (nums.length-1); i++){
            if(md < nums[i+1]-nums[i]){
                md = nums[i+1]-nums[i];
            }
        }
        return md;
    }
}