class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long s = 1;
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < time.length; i++){
            min = Math.min(min , time[i]);
        }
        long e = min*totalTrips;
        while(s < e){
            long m = s+(e-s)/2;
            long s1 = 0;
            for(int i = 0; i < time.length; i++){
                s1 += m/time[i];
            }
            if(s1 >= totalTrips)
            e = m;
            else
            s = m+1;
        }
        return s;
    }
}