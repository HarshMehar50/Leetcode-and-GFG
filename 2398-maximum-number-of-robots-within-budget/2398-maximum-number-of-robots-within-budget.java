class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        long s = 0;
        int ans = 0;
        int l = 0;
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int r = 0; r < chargeTimes.length; r++){
            f.put(chargeTimes[r] , f.getOrDefault(chargeTimes[r] , 0)+1);
            s += runningCosts[r];
            while(l <= r && (f.lastKey() != null && (long)f.lastKey()+((long)(r-l+1)*s) > budget)){
                f.put(chargeTimes[l] , f.get(chargeTimes[l])-1);
                if(f.get(chargeTimes[l]) == 0)
                f.remove(chargeTimes[l]);
                s -= runningCosts[l];
                l++;
            }
            ans = Math.max(ans , r-l+1);
        }
        return ans;
    }
}