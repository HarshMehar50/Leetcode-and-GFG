class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[2] , y[2]));
        for(int i = 0; i < points.length; i++){
            pq.offer(new int[]{points[i][0] , points[i][1] , points[i][0]*points[i][0] + points[i][1]*points[i][1]});
        }
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            int x = pq.peek()[0];
            int y = pq.peek()[1];
            ans[i] = new int[]{x , y};
            pq.poll();
        }
        return ans;
    }
}