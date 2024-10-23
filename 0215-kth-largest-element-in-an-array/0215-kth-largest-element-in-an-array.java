class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i] , i});
        }
        for(int i = 0; i < k-1; i++){
            pq.poll();
        }
        return pq.peek()[0];
    }
}