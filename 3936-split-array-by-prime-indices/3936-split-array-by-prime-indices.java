class Solution {
    boolean[] seive(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= n; i++){
            if(p[i]){
                if((long)((long)i*(long)i) <= n){
                for(int j = i*i; j <= n; j += i){
                    p[j] = false;
                }
                }
            }
        }
        return p;
    }
    public long splitArray(int[] nums) {
        boolean[] prime = seive(nums.length);
        long sa = 0;
        long sb = 0;
        for(int i = 0; i < nums.length; i++){
            if(prime[i])
            sa += nums[i];
            else
            sb += nums[i];
        }
        return Math.abs(sa-sb);
    }
}