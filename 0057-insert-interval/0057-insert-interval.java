class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] a = new int[intervals.length+1][2];
        for(int i = 0; i < intervals.length; i++){
            a[i][0] = intervals[i][0];
            a[i][1] = intervals[i][1];
        }
        a[a.length-1][0] = newInterval[0];
        a[a.length-1][1] = newInterval[1];
        Arrays.sort(a , (x , y)->Integer.compare(x[0] , y[0]));
        List<int[]> l = new ArrayList<>();
        l.add(a[0]);
        for(int i = 1; i < a.length; i++){
            if(a[i][0] > l.get(l.size()-1)[1])
            l.add(a[i]);
            else
            l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1] , a[i][1]);
        }
        int[][] ans = new int[l.size()][2];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}