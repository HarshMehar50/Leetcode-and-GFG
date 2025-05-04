class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            pq.offer(new int[]{nums.get(i).get(0) , i , 0});
            min = Math.min(min , nums.get(i).get(0));
            max = Math.max(max , nums.get(i).get(0));
        }
        int s = min;
        int e = max;
        while(pq.size() == nums.size()){
            int ce = pq.peek()[0];
            int cr = pq.peek()[1];
            int cc = pq.peek()[2];
            pq.poll();
            if(cc+1 < nums.get(cr).size()){
                pq.offer(new int[]{nums.get(cr).get(cc+1) , cr , cc+1});
                max = Math.max(max , nums.get(cr).get(cc+1));
                min = pq.peek()[0];
            }
            if(max-min < e-s){
                s = min;
                e = max;
            }
        }
        return new int[]{s , e};
    }
}