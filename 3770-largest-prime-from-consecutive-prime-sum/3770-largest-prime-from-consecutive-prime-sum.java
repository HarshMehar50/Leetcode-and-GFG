class Solution {
    public int largestPrime(int n) {
        if(n < 2)
        return 0;
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        for(int i = 2; i <= n; i++){
            if(p[i] && (long)((long)i*(long)i) <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
            }
        }
        p[0] = false;
        p[1] = false;
        List<Integer> l = new ArrayList<>();
        l.add(2);
        for(int i = 3; i <= n; i++){
            if(p[i] && l.get(l.size()-1)+i <= n)
            l.add(l.get(l.size()-1)+i);
        }
        for(int i = l.size()-1; i >= 0; i--){
            if(p[l.get(i)])
            return l.get(i);
        }
        return -1;
    }
}