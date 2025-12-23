class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            pq.offer(new int[]{nums[i] , i});
            if(s.charAt(i) == '1'){
                ans += pq.peek()[0];
                pq.poll();
            }
        }
        return ans;
    }
}