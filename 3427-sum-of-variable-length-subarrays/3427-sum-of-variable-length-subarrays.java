class Solution {
    public int subarraySum(int[] nums) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += ps[i];
            if(Math.max(0 , i-nums[i]) != 0)
            ans -= ps[Math.max(0 , i-nums[i])-1];
        }
        return ans;
    }
}