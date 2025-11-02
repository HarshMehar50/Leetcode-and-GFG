class Solution {
    int gcd(int a , int b){
        if(b == 0)
            return Math.abs(a);
        return gcd(b , a%b);
    }
    boolean predicate(int[] d , int[] r , long m){
        long t0 = m-(m/r[0]);
        long t1 = m-(m/r[1]);
        long lcm = (r[0]*r[1])/gcd(r[0] , r[1]);
        long tl = m-(m/lcm);
        long tf = ((m/r[0])+(m/r[1])-(m/lcm));
        if(t0 >= d[0] && t1 >= d[1] && tl >= d[0]+d[1])
            return true;
        else
            return false;
    }
    public long minimumTime(int[] d, int[] r) {
        long ans = 0;
        /*int hops0 = d[0]/(r[0]-1);
        if(d[0]%(r[0]-1) != 0)
            hops0++;
        int hops1 = d[1]/(r[1]-1);
        if(d[1]%(r[1]-1) != 0)
            hops1++;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        for(int i = 1; i <= hops1; i++){
            l1.add(i*r[1]);
        }
        for(int i = 1; i <= hops0; i++){
            l0.add(i*r[0]);
        }
        int c0nc1 = 0;
        for(int i = 0; i < l1.size(); i++){
            int bs = Collections.binarySearch(l0 , l1.get(i));
            if(bs >= l1.size() || bs < 0)
                c0nc1++;
        }
        int c1nc0 = 0;
        for(int i = 0; i < l0.size(); i++){
            int bs = Collections.binarySearch(l1 , l0.get(i));
            if(bs >= l0.size() || bs < 0)
                c1nc0++;
        }*/
        long s = 0;
        long e = (long)(1e18);
        ans = -1;
        while(s <= e){
            long m = s+(e-s)/2;
            if(predicate(d , r , m)){
                ans = m;
                e = m-1;
            }else
                s = m+1;
        }
        return s;
    }
}