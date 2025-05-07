class Solution {
    final int mod = 1000000007;
    public int maximumXorProduct(long a, long b, int n) {
        long axorx = 0;
        long bxorx = 0;
        for(int i = 49; i >= n; i--){
            long aset = ((a>>i)&1);
            long bset = ((b>>i)&1);
            if(aset > 0)
                axorx ^= (1L<<i);
            if(bset > 0)
                bxorx ^= (1L<<i);
        }
        for(long i = n-1; i >= 0; i--){
            long aset = (a&(1L<<i));
            long bset = (b&(1L<<i));
            if(aset == bset){
                axorx ^= (1L<<i);
                bxorx ^= (1L<<i);
                continue;
            }
            if(axorx > bxorx)
                bxorx ^= (1L<<i);
            else
                axorx ^= (1L<<i);
        }
        axorx = axorx%mod;
        bxorx = bxorx%mod;
        return (int)((axorx*bxorx)%mod);
    }
}