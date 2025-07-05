class Solution {
    final int mod = 1000000007;
    long binExpo(long a , long b){
        long ans = 1;
        a = a%mod;
        while(b > 0){
            if((b&1) == 1)
            ans = (ans*a)%mod;
            a = (a*a)%mod;
            b = b>>1;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long e = (n+1)/2;
        long o = n/2;
        long p5 = binExpo(5, e);
        long p4 = binExpo(4, o);
        return (int)((p5*p4)%mod);
    }
}