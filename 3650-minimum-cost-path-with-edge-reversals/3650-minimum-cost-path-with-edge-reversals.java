class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        HashMap<Integer , List<int[]>> adjrev = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
            adjrev.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adjrev.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{0 , 0});
        int[] d = new int[n];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[0] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            if(node == n-1)
                return distance;
            for(int[] a : adj.get(node)){
                if(distance+a[1] < d[a[0]]){
                    d[a[0]] = distance+a[1];
                    pq.offer(new int[]{d[a[0]] , a[0]});
                }
            }
            for(int[] a : adjrev.get(node)){
                if(distance+a[1] < d[a[0]]){
                    d[a[0]] = distance+(2*a[1]);
                    pq.offer(new int[]{d[a[0]] , a[0]});
                }
            }
        }
        return -1;
    }
}