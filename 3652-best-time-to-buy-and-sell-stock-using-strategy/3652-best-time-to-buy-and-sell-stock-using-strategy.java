class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long ans = Long.MIN_VALUE;
        int[] a = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            a[i] = prices[i]*strategy[i];
        }
        long[] ps = new long[a.length];
        long[] psabs = new long[prices.length];
        ps[0] = a[0];
        for(int i = 1; i < a.length; i++){
            ps[i] = ps[i-1]+a[i];
        }
        psabs[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            psabs[i] = psabs[i-1]+prices[i];
        }
        for(int i = 0; i+k-1 < psabs.length; i++){
            long oss = ps[i+k-1];
            if(i != 0)
                oss -= ps[i-1];
            long mss = psabs[i+k-1];
            if(i+(k/2) != 0)
                mss -= psabs[i+(k/2)-1];
            ans = Math.max(ans , ps[a.length-1]-oss+mss);
        }
        return Math.max(ans , ps[ps.length-1]);
    }
}