class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long ans = 0;
        if(n > k)
            ans += (long)k*(long)(n-k);
        if(m > k)
            ans += (long)k*(long)(m-k);
        return ans;
    }
}