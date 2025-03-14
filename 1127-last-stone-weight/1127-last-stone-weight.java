class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        for(int i = 0; i < stones.length; i++){
            pq.offer(new int[]{stones[i] , i});
        }
        while(pq.size() != 1){
            int s1 = pq.peek()[0];
            pq.poll();
            int s2 = pq.peek()[0];
            pq.poll();
            pq.offer(new int[]{s1-s2 , stones.length});
        }
        return pq.peek()[0];
    }
}