class Solution {
    HashMap<Integer , Integer> primeFactorization(int x , int[] spf){
        HashMap<Integer , Integer> map = new HashMap<>();
        while(x != 1){
            int p = spf[x];
            int c = 0;
            while(x%p == 0){
                c++;
                x = x/p;
            }
            map.put(p , c);
        }
        return map;
    }
    public int smallestValue(int n) {
        if(n == 4 || n == 1)
            return n;
        boolean[] p = new boolean[n+1];
        int[] spf = new int[n+1];
        Arrays.fill(p , true);
        Arrays.fill(spf , Integer.MAX_VALUE);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= n; i++){
            if(p[i]){
                spf[i] = i;
                if((long)((long)i*(long)i) <= n){
                    for(int j = i*i; j <= n; j += i){
                        p[j] = false;
                        spf[j] = Math.min(spf[j] , i);
                    }
                }
            }
        }
        while(!p[n]){
            HashMap<Integer , Integer> map = primeFactorization(n , spf);
            int t = 0;
            for(Integer x : map.keySet()){
                t += x*map.get(x);
            }
            n = t;
        }
        return n;
    }
}