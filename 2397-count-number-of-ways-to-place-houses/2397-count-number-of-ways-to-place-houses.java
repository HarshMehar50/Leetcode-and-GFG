class Solution {
    public int countHousePlacements(int n) {
        long[] series = new long[n+2];
        series[0] = 1;
        series[1] = 1;
        final int mod = 1000000007;
        for(int i = 2; i < n+2; i++){
            series[i] = (series[i-1]+series[i-2])%mod;
        };
        int ans =(int)((series[n+1]*series[n+1])%mod);
        return ans;
    }
}