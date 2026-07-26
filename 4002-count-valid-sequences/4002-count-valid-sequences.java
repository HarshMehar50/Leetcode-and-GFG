class Solution {
    final int mod = 1000000007;
    long binExpoMod(long a , long b){
        long ans = 1;
        while(b > 0){
            if((b&1) != 0)
            ans = (ans*a)%mod;
            a = (a*a)%mod;
            b >>= 1;
        }
        return ans;
    }
    long nCr(int n , int r , long[] f , long[] invf){
        if(r < 0 || r > n)
        return 0;
        return (((f[n]*invf[r])%mod)*invf[n-r])%mod;
    }
    public int countValidSequences(int n, int k) {
        long[] f = new long[n+1];
        f[0] = 1;
        for(int i = 1; i <= n; i++){
            f[i] = (f[i-1]*i)%mod;
        }
        long[] invf = new long[n+1];
        invf[n] = binExpoMod(f[n] , mod-2);
        for(int i = n; i >= 1; i--){
            invf[i-1] = (invf[i]*i)%mod;
        }
        long total = nCr(n-1 , k-1 , f , invf);
        long odd = 0;
        if((n-k)%2 == 0){
            int m = (n-k)/2;
            odd = nCr(m+k-1 , k-1 , f , invf);
        }
        return (int)((total-odd+mod)%mod);
    }
}