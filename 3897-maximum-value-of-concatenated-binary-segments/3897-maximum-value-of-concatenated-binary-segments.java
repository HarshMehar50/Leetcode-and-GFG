class Solution {
    final int mod = 1000000007;
    long binExpo(long a , long b){
        long ans = 1;
        a %= mod;
        while(b > 0){
            if((b&1) == 1)
                ans = (ans*a)%mod;
            a = (a*a)%mod;
            b >>= 1;
        }
        return ans;
    }
    public int maxValue(int[] nums1, int[] nums0) {
        /*int[][] a = new int[nums1.length][3];
        for(int i = 0; i < a.length; i++){
            a[i][0] = nums1[i];
            a[i][1] = nums0[i];
            a[i][2] = a[i][0]+a[i][1];
        }
        Arrays.sort(a , (x , y)->Integer.compare(y[0] , x[0]));
        long ans = 0;
        int itn = 0;
        for(int i = a.length-1; i >= 0; i--){
            long add = (binExpo(2 , a[i][2]+itn)-1+mod)%mod;
            long sub = (binExpo(2 , a[i][1]+itn)-1+mod)%mod;
            add = (add-sub+mod)%mod;
            ans = (ans+add)%mod;
            itn += a[i][2];
        }
        
        return (int)ans*/;
        List<int[]> l = new ArrayList<>();
        int last = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums0[i] == 0)
            last += nums1[i];
            else
            l.add(new int[]{nums1[i] , nums0[i]});
        }
        Collections.sort(l , (x , y)->(x[0] != y[0])?Integer.compare(y[0] , x[0]):Integer.compare(x[1] , y[1]));
        long ans = 0;
        long e = 0;
        for(int i = l.size()-1; i >= 0; i--){
            e += l.get(i)[1];
            long v1 = binExpo(2 , e);
            long rem = binExpo(2 , l.get(i)[0]);
            long fv = (v1*((rem-1+mod)%mod))%mod;
            ans = (ans+fv)%mod;
            e += l.get(i)[0];
        }
        long v1 = binExpo(2 , e);
        long rem = binExpo(2 , last);
        long fv = (v1*((rem-1+mod)%mod))%mod;
        ans = (ans+fv)%mod;
        return (int)ans;
    }
}