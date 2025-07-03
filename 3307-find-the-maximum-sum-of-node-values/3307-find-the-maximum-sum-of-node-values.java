class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        int c = 0;
        int minxor = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if((nums[i]^k) > nums[i]){
                ans += nums[i]^k;
                c++;
            }else
                ans += nums[i];
            minxor = Math.min(minxor , Math.abs(nums[i]-(nums[i]^k)));
        }
        if(c%2 == 1)
            ans = ans-minxor;
        return ans;
    }
}