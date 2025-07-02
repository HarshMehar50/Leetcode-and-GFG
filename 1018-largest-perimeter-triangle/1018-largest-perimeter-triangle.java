class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length-1; i >= 2; i--){
            if(nums[i]+nums[i-1] > nums[i-2] && nums[i]+nums[i-2] > nums[i-1] && nums[i-2]+nums[i-1] > nums[i])
            ans = Math.max(nums[i]+nums[i-1]+nums[i-2] , ans);
        }
        return ans;
    }
}