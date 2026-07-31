class KthLargest {
    PriorityQueue<int[]> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        for(int i = 0; i < nums.length; i++){
            pq.offer(new int[]{nums[i] , i});
            if(pq.size() > K)
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(new int[]{val , 0});
        if(pq.size() > K)
        pq.poll();
        return pq.peek()[0];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */