class Solution {
    int solve(int[] nums , int k){
        int s = 0;
        int l = 0;
        int ans = 0;
        for(int r = 0; r < nums.length; r++){
            s += nums[r];
            while(l <= r && s > k){
                s -= nums[l];
                l++;
            }
            ans += r-l+1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = solve(nums , goal)-solve(nums , goal-1);
        return ans;
    }
}