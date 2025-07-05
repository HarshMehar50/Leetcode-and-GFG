class Solution {
    Set<Integer> set;
    void primeFactorization(int x , int[] spf){
        while(x != 1){
            int p = spf[x];
            int c = 0;
            while(x%p == 0){
                c++;
                x = x/p;
            }
            set.add(p);
        }
    }
    public int distinctPrimeFactors(int[] nums) {
        set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i] , max);
        }
        boolean[] p = new boolean[max+1];
        int[] spf = new int[max+1];
        Arrays.fill(p , true);
        Arrays.fill(spf , Integer.MAX_VALUE);
        p[0] = false;
        p[1] = false;
        for(int i = 2; i <= max; i++){
            if(p[i]){
                spf[i] = i;
                for(int j = i*i; j <= max; j += i){
                    p[j] = false;
                    spf[j] = Math.min(spf[j] , i);
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            primeFactorization(nums[i] , spf);
        }
        return set.size();
    }
}