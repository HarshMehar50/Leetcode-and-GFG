class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i += 2){
            int tn = nums[i]*(int)Math.pow(10 , Integer.toString(nums[i+1]).length())+nums[i+1];
            ans = Math.min(ans , tn);
        }
        return ans;
    }
}