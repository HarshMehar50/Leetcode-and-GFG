class Solution {
    long gcd(long a , long b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    long lcm(long a , long b){
        return (a*b)/gcd(a , b);
    }
    public long maxScore(int[] nums) {
        long[] pgcd = new long[nums.length];
        long[] sgcd = new long[nums.length];
        pgcd[0] = nums[0];
        sgcd[sgcd.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            pgcd[i] = gcd(pgcd[i-1] , nums[i]);
        }
        for(int i = nums.length-2; i >= 0; i--){
            sgcd[i] = gcd(sgcd[i+1] , nums[i]);
        }
        long[] plcm = new long[nums.length];
        long[] slcm = new long[nums.length];
        plcm[0] = nums[0];
        slcm[slcm.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            plcm[i] = lcm(plcm[i-1] , nums[i]);
        }
        for(int i = nums.length-2; i >= 0; i--){
            slcm[i] = lcm(slcm[i+1] , nums[i]);
        }
        long ans = pgcd[pgcd.length-1]*plcm[plcm.length-1];
        for(int i = 0; i < nums.length; i++){
            long lg = 0;
            long rg = 0;
            if(i != 0)
            lg = pgcd[i-1];
            if(i != nums.length-1)
            rg = sgcd[i+1];
            long g = gcd(lg , rg);
            long ll = 1;
            long rl = 1;
            if(i != 0)
            ll = plcm[i-1];
            if(i != nums.length-1)
            rl = slcm[i+1];
            long l = lcm(ll , rl);
            ans = Math.max(ans , l*g);
        }
        return ans;
    }
}