class Solution {
    final int mod = 1000000007;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] d = new int[nums.length];
        for(int i = 0; i < requests.length; i++){
            d[requests[i][0]]++;
            if(requests[i][1] != nums.length-1)
            d[requests[i][1]+1]--;
        }
        for(int i = 1; i < d.length; i++){
            d[i] += d[i-1];
        }
        Arrays.sort(d);
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = ((ans%mod)+(long)((long)(d[i]%mod)*(long)(nums[i]%mod))%mod)%mod;
        }
        return (int)ans;
    }
}