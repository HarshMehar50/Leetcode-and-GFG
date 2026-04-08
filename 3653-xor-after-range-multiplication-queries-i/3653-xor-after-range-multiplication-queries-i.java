class Solution {
    final int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long[] a = new long[nums.length];
        for(int i = 0; i < a.length; i++){
            a[i] = nums[i];
        }
        for(int i = 0; i < queries.length; i++){
            for(int j = queries[i][0]; j <= queries[i][1]; j += queries[i][2]){
                a[j] = ((a[j]%mod)*(queries[i][3]%mod))%mod;
            }
        }
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = (ans^a[i]);
        }
        return (int)ans;
    }
}