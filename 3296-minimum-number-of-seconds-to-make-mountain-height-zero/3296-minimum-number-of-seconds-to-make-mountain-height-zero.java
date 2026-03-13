class Solution {
    boolean predicate(int mountainHeight , int[] workerTimes , long s1 , long m){
        /*long c = m/s1;
        double x = (Math.sqrt(1+(8*c))-1)/2;
        long fx = (long)Math.floor(x);
        if(fx*workerTimes.length >= mountainHeight)
        return true;
        else
        return false;*/
        long s = 0;
        for(int i = 0; i < workerTimes.length; i++){
            long c = m/workerTimes[i];
            long x = (long)((Math.sqrt(1 + 8.0 * c) - 1) / 2);
            s += x;
            if(s >= mountainHeight)
            return true; 
        }
        return false;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long s = 1;
        long e = (long)(1e18);
        long ans = -1;
        long s1 = 0;
        for(int i = 0; i < workerTimes.length; i++){
            s1 += workerTimes[i];
        }
        while(s <= e){
            long m = s+(e-s)/2;
            if(predicate(mountainHeight , workerTimes , s1 , m)){
                ans = m;
                e = m-1;
            }else
            s = m+1;
        }
        return ans;
    }
}