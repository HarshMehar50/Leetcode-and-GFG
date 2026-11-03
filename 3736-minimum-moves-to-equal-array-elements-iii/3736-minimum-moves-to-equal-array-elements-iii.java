class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += Math.abs(nums[nums.length-1]-nums[i]);
        }
        return ans;
    }
}