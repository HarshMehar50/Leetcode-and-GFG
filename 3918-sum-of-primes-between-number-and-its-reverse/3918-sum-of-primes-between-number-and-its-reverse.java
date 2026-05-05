class Solution {
    public int sumOfPrimesInRange(int n) {
        int r = 0;
        for(int i = n; i > 0; i = i/10){
            r = (r*10)+(i%10);
        }
        boolean[] p = new boolean[Math.max(n , r)+1];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i < p.length; i++){
            if(p[i] && (long)((long)i*(long)i) < p.length){
                for(int j = i*i; j < p.length; j += i){
                    p[j] = false;
                }
            }
        }
        int ans = 0;
        for(int i = Math.min(n , r); i <= Math.max(n , r); i++){
            if(p[i])
            ans += i;
        }
        return ans;
    }
}