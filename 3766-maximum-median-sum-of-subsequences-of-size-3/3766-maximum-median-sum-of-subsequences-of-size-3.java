class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        int c = 0;
        while(c != nums.length/3){
            ans += nums[nums.length-(2*(c+1))];
            c++;
        }
        return ans;
    }
}