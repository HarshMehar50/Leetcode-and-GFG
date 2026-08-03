class Solution {
    boolean predicate(int[] monsters , long[] d , long m){
        long[] d1 = new long[d.length];
        for(int i = 0; i < d.length; i++){
            d1[i] = d[i];
        }
        for(int i = 0; i < monsters.length; i++){
            if(m+d1[i] < monsters[i])
            return false;
            m -= monsters[i];
            if(m < 0)
            m = 0;
        }
        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long[] d = new long[monsters.length];
        for(int[] a : boosts){
            d[a[0]] += a[2];
            if(a[1]+1 < d.length)
            d[a[1]+1] -= a[2];
        }
        long e = (long)(1e18);
        for(int i = 1; i < d.length; i++){
            d[i] += d[i-1];
            //e += monsters[i];
        }
        long s = 0;
        long ans = -1;
        while(s <= e){
            long m = s+(e-s)/2;
            if(predicate(monsters , d , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}