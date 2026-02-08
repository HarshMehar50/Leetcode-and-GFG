class Solution {
    public int dominantIndices(int[] nums) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        int ans = 0;
        for(int i = 0; i < nums.length-1; i++){
            int s = ps[ps.length-1]-ps[i];
            if(nums[i] > s/(nums.length-1-i))
            ans++;
        }
        return ans;
    }
}