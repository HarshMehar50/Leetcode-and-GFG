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
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i]%2;
        }
        int ans = solve(nums , k)-solve(nums , k-1);
        return ans;
    }
}