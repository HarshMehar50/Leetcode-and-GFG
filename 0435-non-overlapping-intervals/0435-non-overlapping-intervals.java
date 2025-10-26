class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (x , y)->Integer.compare(x[1] , y[1]));
        int ans = 0;
        int[] p = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(p[1] <= intervals[i][0])
            p = intervals[i];
            else
            ans++;
        }
        return ans;
    }
}