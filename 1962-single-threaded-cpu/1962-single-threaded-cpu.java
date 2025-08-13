class Solution {
    public int[] getOrder(int[][] tasks) {
        int t = 0;
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((x , y)->(x[1] != y[1])?Integer.compare(x[1] , y[1]):Integer.compare(x[2] , y[2]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < tasks.length; i++){
            pq2.offer(new int[]{tasks[i][0] , tasks[i][1] , i});
        }
        t = Math.max(t , pq2.peek()[0]);
        while(!pq2.isEmpty() && pq2.peek()[0] <= t){
            pq1.offer(pq2.poll());
        }
        List<Integer> l = new ArrayList<>();
        while(!pq1.isEmpty()){
            int ptime = pq1.peek()[1];
            int pid = pq1.peek()[2];
            l.add(pid);
            pq1.poll();
            t = t+ptime;
            while(!pq2.isEmpty() && t >= pq2.peek()[0]){
                pq1.offer(pq2.poll());
            }
            if(pq1.isEmpty() && !pq2.isEmpty()){
                t = Math.max(t , pq2.peek()[0]);
                while(!pq2.isEmpty() && t >= pq2.peek()[0]){
                    pq1.offer(pq2.poll());
                }
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
}