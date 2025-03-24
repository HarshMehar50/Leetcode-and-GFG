class Solution {
    public int countDays(int days, int[][] meetings) {
       List<int[]> l = new ArrayList<>();
       Arrays.sort(meetings , (x , y)->Integer.compare(x[0] , y[0]));
       l.add(meetings[0]);
       for(int i = 1; i < meetings.length; i++){
           if(l.get(l.size()-1)[1] < meetings[i][0])
           l.add(meetings[i]);
           else
           l.get(l.size()-1)[1] = Math.max(meetings[i][1] , l.get(l.size()-1)[1]);
       }
       int c = 0;
       for(int i = 0; i < l.size(); i++){
        c += (l.get(i)[1]-l.get(i)[0]+1);
       }
       return days-c;
    }
}