class Solution {
    final int mod = 1337;
    long binExpoMod(long a , long b){
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
    public int superPow(int a, int[] b) {
        if(a == 1)
        return 1;
        /*long[] p = new long[b.length];
        for(int i = 0; i < b.length; i++){
            p[i] = (b[i]*binExpoMod(10 , b.length-1-i));
        }
        long pv = 0;
        for(int i = 0; i < p.length; i++){
            pv = (pv+p[i]);
        }
        long ans = binExpoMod(a , pv);
        return (int)ans;*/
        if(a%mod == 0)
        return 0;
        long ans = 1;
        for(int i = 0; i < b.length; i++){
            ans = binExpoMod(ans , 10);
            ans = (ans*binExpoMod(a , b[i]))%mod;
        }
        return (int)ans;
    }
}