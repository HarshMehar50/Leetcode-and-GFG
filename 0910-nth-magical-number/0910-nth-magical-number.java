class Solution {
    final int mod = 1000000007;
    int GCD(int a, int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    int LCM(int a, int b) {
        if (a == 0 || b == 0) 
        return 0; 
        return (a/GCD(a, b))*b;
    }
    public int nthMagicalNumber(int n, int a, int b) {
        int lcm = LCM(a , b);
        long s = 1;
        long e = (long)((long)Math.min(a , b)*(long)n);
        long ans = 0;
        while(s <= e){
            /*long m = s+(e-s)/2;
            int na = (int)(m/a);
            int nb = (int)(m/b);
            int nlcm = (int)(m/lcm);
            int x = na+nb-nlcm;
            if(x == n){
            long ma = (m/a)*a;
            long mb = (m/b)*b;
            long mlcm = (m/lcm)*lcm;
            if((int)(ma/a)+(int)(ma/b)+(int)(ma/lcm) == n)
            return (int)(ma%mod);
            else if((int)(mb/a)+(int)(mb/b)+(int)(mb/lcm) == n)
            return (int)(mb%mod);
            else if((int)(mlcm/a)+(int)(mlcm/b)+(int)(mlcm/lcm) == n)
            return (int)(mlcm%mod);
            }else if(x < n)
            s = m+1;
            else
            e = m-1;*/
            long m = s+(e-s)/2;
            long c = m/a + m/b - m/lcm;
            if((int)c < n)
            s = m+1;
            else{
                e = m-1;
                ans = m;
            }
        }
        return (int)(ans%mod);
    }
}