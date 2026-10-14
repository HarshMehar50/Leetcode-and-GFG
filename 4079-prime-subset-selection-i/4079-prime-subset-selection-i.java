class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= n; i++){
            if(p[i] && (long)i*(long)i <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(s <= 0)
            break;
            if(p[i] && s-i >= 0){
                ans.add(i);
                s -= i;
            }
        }
        return ans;
    }
}