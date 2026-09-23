class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals , (x , y)->Integer.compare(x[0] , y[0]));
        long ans = 0;
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0] , i+1);
        }
        for(int i = 0; i < intervals.length; i++){
            ans += map.getOrDefault(map.floorKey(intervals[i][1]) , 0)-(i+1);
        }
        return ans;
    }
}