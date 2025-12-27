class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] f = new int[n];
        PriorityQueue<long[]> pqm = new PriorityQueue<long[]>((x , y)->(x[1] != y[1])?Long.compare(x[1] , y[1]):Long.compare(x[2] , y[2]));
        PriorityQueue<int[]> pqr = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        Arrays.sort(meetings , (x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < n; i++){
            pqr.offer(new int[]{i});
        }
        for(int i = 0; i < meetings.length; i++){
            long s = meetings[i][0];
            while(!pqm.isEmpty() && meetings[i][0] >= pqm.peek()[1]){
                int r = (int)pqm.peek()[2];
                pqm.poll();
                pqr.offer(new int[]{r});
            }
            if(pqr.isEmpty()){
                long[] e = pqm.poll();
                s = e[1];
                pqr.offer(new int[]{(int)e[2]});
            }
            int r = pqr.peek()[0];
            f[r]++;
            pqr.poll();
            pqm.offer(new long[]{meetings[i][0] , (long)(s+(long)meetings[i][1]-(long)meetings[i][0]) , r});
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max , f[i]);
        }
        int ans = 0;
        System.out.println(Arrays.toString(f));
        for(int i = 0; i < n; i++){
            if(f[i] == max){
                ans = i;
                break;
            }
        }
        return ans;
    }
}