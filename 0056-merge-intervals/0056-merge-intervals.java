class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (x , y)->Integer.compare(x[0] , y[0]));
        List<int[]> l = new ArrayList<>();
        l.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > l.get(l.size()-1)[1])
            l.add(intervals[i]);
            else
            l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1] , intervals[i][1]);
        }
        int[][] ans = new int[l.size()][2];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}