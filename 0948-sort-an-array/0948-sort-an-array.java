class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i] , i});
        }
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = pq.peek()[0];
            pq.poll();
        }
        return ans;
    }
}