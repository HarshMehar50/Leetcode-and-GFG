class Solution {
    boolean[] seive(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= n; i++){
            if(p[i]){
                if((long)((long)i*(long)i) <= (long)n){
                    for(int j = i*i; j <= n; j += i){
                        p[j] = false;
                    }
                }
            }
        }
        return p;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] prime = seive(n);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 2; i <= n/2; i++){
            if(prime[i] && prime[n-i]){
                List<Integer> inner = new ArrayList<>();
                inner.add(Math.min(i , n-i));
                inner.add(Math.max(i , n-i));
                //if(!ans.contains(inner))
                ans.add(inner);
            }
        }
        return ans;
    }
}