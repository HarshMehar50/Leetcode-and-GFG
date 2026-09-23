class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals , (x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < intervals.length; i++){
            for(int j = i+1; j < intervals.length; j++){
                if(intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1])
                ans++;
            }
        }
        return ans;
    }
}