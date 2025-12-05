class Solution {
    public int countPartitions(int[] nums) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        int ans = 0;
        for(int i = 0; i < nums.length-1; i++){
            int ls = ps[i];
            int rs = ps[ps.length-1]-ls;
            if(Math.abs(rs-ls)%2 == 0)
            ans++;
        }
        return ans;
    }
}