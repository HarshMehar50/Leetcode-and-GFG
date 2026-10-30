class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1] , e[2]});
        }
        int[][] d = new int[n][k+1];
        for(int[] a : d){
            Arrays.fill(a , Integer.MAX_VALUE);
        }
        d[0][1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        pq.offer(new int[]{0 , 0 , labels.charAt(0)-'a' , 1});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            int label = pq.peek()[2];
            int count = pq.peek()[3];
            pq.poll();
            if(node == n-1)
                return distance;
            for(int[] a : adj.get(node)){
                int nc = 0;
                if(labels.charAt(a[0])-'a' == label)
                    nc = count+1;
                else
                    nc = 1;
                if(nc <= k && a[1]+distance < d[a[0]][nc]){
                    d[a[0]][nc] = a[1]+distance;
                    pq.offer(new int[]{d[a[0]][nc] , a[0] , labels.charAt(a[0])-'a' , nc});
                }
            }
        }
        return -1;
    }
}