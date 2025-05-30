class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        /*Queue<int[]> q = new LinkedList<>();
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1 , Integer.MAX_VALUE);
        Arrays.fill(d2 , Integer.MAX_VALUE);
        d1[1] = 0;
        q.offer(new int[]{1 , 1});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int count = q.peek()[1];
            int distance = 0;
            if(count == 1)
            distance = d1[node];
            else
            distance = d2[node];
            if(node == n && d2[n] != Integer.MAX_VALUE)
            return d2[n];
            if((distance/change)%2 == 1)
            distance = change*((distance/change)+1);
            for(Integer x : adj.get(node)){
                if(d1[x] == Integer.MAX_VALUE){
                    d1[x] = distance+time;
                    q.offer(new int[]{x , 1});
                }else if(d2[x] == Integer.MAX_VALUE && d1[x] != distance+time){
                    d2[x] = distance+time;
                    q.offer(new int[]{x , 2});
                }
            }
        }
        return -1;*/
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d1 = new int[n+1];
        int[] d2 = new int[n+1];
        Arrays.fill(d1 , Integer.MAX_VALUE);
        d1[1] = 0;
        Arrays.fill(d2 , Integer.MAX_VALUE);
        pq.offer(new int[]{0 , 1});
        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int distance = pq.peek()[0];
            pq.poll();
            if(node == n && d2[node] != Integer.MAX_VALUE)
                return d2[node];
            if((distance/change)%2 == 1)
                distance = change*((distance/change)+1);
            for(Integer x : adj.get(node)){
                if(distance+time < d1[x]){
                    d2[x] = d1[x];
                    d1[x] = distance+time;
                    pq.offer(new int[]{d1[x] , x});
                }else if(distance+time < d2[x] && d1[x] != distance+time){
                    d2[x] = distance+time;
                    pq.offer(new int[]{distance+time , x});
                }
            }
        }
        return -1;
    }
}