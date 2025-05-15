class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new int[]{times[i][2] , times[i][1]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n+1];
        Arrays.fill(d , Integer.MAX_VALUE);
        pq.offer(new int[]{0 , k});
        d[k] = 0;
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            max = Math.max(max , d[i]);
        }
        if(max == Integer.MAX_VALUE)
            return -1;
        else
            return max;
    }
}