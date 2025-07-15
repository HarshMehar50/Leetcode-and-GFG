class Solution {
    public int minTime(int n, int[][] edges) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n];
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2] , edges[i][3]});
        }
        Arrays.fill(d , Integer.MAX_VALUE);
        d[0] = 0;
        pq.offer(new int[]{0 , 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int t = pq.peek()[0];
            pq.poll();
            if(node == n-1)
            return t;
            for(int[] a : adj.get(node)){
                int adjnode = a[0];
                int s = a[1];
                int e = a[2];
                int nt = Math.max(s , t);
                if(nt <= e && nt+1 < d[adjnode]){
                    d[adjnode] = nt+1;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return -1;
    }
}