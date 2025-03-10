class Solution {
    public int minimumAverageDifference(int[] nums) {
        long[] ps = new long[nums.length];
        ps[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i];
        }
        long[] avgp = new long[nums.length];
        long[] avgs = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            avgp[i] = ps[i]/(i+1);
        }
        for(int i = 0; i < nums.length-1; i++){
            avgs[i] = (ps[nums.length-1]-ps[i])/(nums.length-1-i);
        }
        long min = Long.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min , Math.abs(avgp[i]-avgs[i]));
        }
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            if(min == Math.abs(avgp[i]-avgs[i])){
                ans = i;
                break;
            }
        }
        return ans;
    }
}