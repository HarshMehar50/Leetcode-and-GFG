class Solution {
    final int mod = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] ps = new int[n];
        ps[0] = nums[0];
        for(int i = 1; i < n; i++){
            ps[i] = (ps[i-1]+nums[i])%mod;
        }
        List<Integer> list = new ArrayList<>();
        for(int l = 1; l <= n; l++){
            for(int i = 0; i+l-1 < n; i++){
                int ss = 0;
                ss = (ss+ps[i+l-1])%mod;
                if(i != 0)
                ss = (ss-ps[i-1]+mod)%mod;
                list.add(ss);
            }
        }
        Collections.sort(list);
        int ans = 0;
        for(int i = left-1; i <= right-1; i++){
            ans = (ans+list.get(i))%mod;
        }
        return ans;
    }
}