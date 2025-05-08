class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long[] ps = new long[nums.length];
        ps[0] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[nums.length-1-i];
        }
        int ans = 0;
        for(int i = 0; i < ps.length; i++){
            if(ps[i] > 0)
            ans++;
        }
        return ans;
    }
}