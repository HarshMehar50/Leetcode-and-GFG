class Solution {
    boolean check(int[] candies , long m , long k){
        long c = 0;
        for(int i = 0; i < candies.length; i++){
            c += candies[i]/m;
        }
        if(c >= k)
        return true;
        else
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        long max = 0;
        for(int i = 0; i < candies.length; i++){
            max = Math.max(max , candies[i]);
            sum += candies[i];
        }
        if(sum < k)
        return 0;
        long s = 1;
        long e = max;
        while(s <= e){
            long m = s+(e-s)/2;
            if(check(candies , m , k))
            s = m+1;
            else
            e = m-1;
        }
        if((int) s != 0)
        return (int)s-1;
        else
        return (int)s;
    }
}