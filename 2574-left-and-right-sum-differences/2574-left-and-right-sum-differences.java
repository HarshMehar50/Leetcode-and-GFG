class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            int ls = 0;
            if(i != 0)
            ls = ps[i-1];
            int rs = ps[ps.length-1]-ps[i];
            ans[i] = Math.abs(ls-rs);
        }
        return ans;
    }
}