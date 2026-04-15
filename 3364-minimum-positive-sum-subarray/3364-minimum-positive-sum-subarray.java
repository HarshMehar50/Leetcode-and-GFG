class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] ps = new int[nums.size()];
        ps[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            ps[i] = ps[i-1]+nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int k = l; k <= r; k++){
            for(int i = 0; i+k-1 < nums.size(); i++){
                int ss = ps[i+k-1];
                if(i != 0)
                ss -= ps[i-1];
                if(ss > 0)
                ans = Math.min(ans , ss);
            }
        }
        if(ans == Integer.MAX_VALUE)
        return -1;
        return ans;
    }
}