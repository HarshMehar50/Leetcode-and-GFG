class Solution {
    int solve(int[] nums, int target , int i , int s){
        if(i == nums.length){
            if(s == target)
            return 1;
            else return 0;
        }
        int p = solve(nums , target , i+1 , s+nums[i]);
        int m = solve(nums , target , i+1 , s-nums[i]);
        int ans = p+m;
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums , target , 0 , 0);
    }
}