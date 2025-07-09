class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> l = new ArrayList<>();
        l.add(startTime[0]);
        for(int i = 1; i < startTime.length; i++){
            l.add(startTime[i]-endTime[i-1]);
        }
        l.add(eventTime-endTime[endTime.length-1]);
        int s = 0;
        for(int i = 0; i <= k; i++){
            s += l.get(i);
        }
        int ans = s;
        for(int i = k+1; i < l.size(); i++){
            s -= l.get(i-(k+1));
            s += l.get(i);
            ans = Math.max(ans , s);
        }
        return ans;
    }
}