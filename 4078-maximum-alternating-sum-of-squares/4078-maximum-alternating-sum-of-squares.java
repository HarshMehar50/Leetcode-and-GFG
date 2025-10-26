class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for(int i = 0; i < (nums.length+1)/2; i++){
            ans += nums[nums.length-1-i]*nums[nums.length-1-i];
        }
        for(int i = 0; i < nums.length-((nums.length+1)/2); i++){
            ans -= nums[i]*nums[i];
        }
        return ans;
    }
}