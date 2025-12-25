class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        for(int[] a : grid){
            Arrays.sort(a);
        }
        long ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        for(int i = 0; i < limits.length; i++){
            for(int j = grid[i].length-1; j >= grid[i].length-limits[i]; j--){
                pq.offer(new int[]{grid[i][j] , limits[i]});
            }
        }
        for(int i = 0; i < k; i++){
            ans += pq.peek()[0];
            pq.poll();
        }
        return ans;
    }
}