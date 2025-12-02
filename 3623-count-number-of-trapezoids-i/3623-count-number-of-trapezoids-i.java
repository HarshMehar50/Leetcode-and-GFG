class Solution {
    int mod = 1000000007;
    long nCr(int n , int r , long[] f , long[] ivf){
        return (((f[n]*ivf[r])%mod)*ivf[n-r])%mod;
    }
    long modI(long a , long b){
        long ans = 1;
        a = a%mod;
        while (b > 0) {
            if ((b&1) == 1) 
                ans = (ans*a)%mod;
            a = (a*a)%mod;
            b >>= 1;
        }
        return ans;
    }
    public int countTrapezoids(int[][] points) {
        Arrays.sort(points , (x , y)->Integer.compare(x[1] , y[1]));
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            map.put(points[i][1] , map.getOrDefault(points[i][1] , 0)+1);
        }
        //Set<Integer> set = map.keySet();
        //List<Integer> ly = new ArrayList<>(set);
        int max = 0;
        for(Integer y : map.keySet()){
            max = Math.max(max , map.get(y));
        }
        long[] f = new long[max+1];
        long[] ivf = new long[max+1];
        f[0] = 1;
        ivf[0] = 1;
        for(int i = 1; i <= max; i++){
            f[i] = (f[i-1]*i)%mod;
        }
        ivf[max] = modI(f[max] , mod-2);
        for(int i = max-1; i >= 1; i--){
            ivf[i] = (ivf[i+1]*(i+1))%mod;
        }
        long ans = 0;
        /*for(int i = 0; i < ly.size(); i++){
            if(map.get(ly.get(i)) > 1){
                for(int j = i+1; j < ly.size(); j++){
                    if(map.get(ly.get(j)) > 1){
                        long v1 = nCr(map.get(ly.get(i)) , 2 , f , ivf)%mod;
                        long v2 = nCr(map.get(ly.get(j)) , 2 , f , ivf)%mod;
                        ans = (ans%mod + (v1*v2)%mod)%mod;
                    }
                }
            }
        }*/
        List<Long> ncrv = new ArrayList<>();
        for(Integer x : map.keySet()){
            if(map.get(x) > 1)
                ncrv.add(nCr(map.get(x) , 2 , f , ivf));
        }
        long s = 0;
        for (long x : ncrv) {
           ans = (ans+(x*s)%mod)%mod;
           s = (s+x)%mod;
        }
        return (int)ans;
    }
}