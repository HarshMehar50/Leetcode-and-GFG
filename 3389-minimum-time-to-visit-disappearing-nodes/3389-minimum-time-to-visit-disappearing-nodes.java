class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[1] , y[1]));
        pq.offer(new int[]{0 , 0});
        int[] d = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[0] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int distance = pq.peek()[1];
            pq.poll();
            if(visited[node]) continue;
            visited[node] = true;
            //if(d[node] == -1) continue;
            for(int i = 0; i < adj.get(node).size(); i++){
                int adjnode = adj.get(node).get(i)[0];
                int weight = adj.get(node).get(i)[1];
                if(weight+distance < d[adjnode] && weight+distance < disappear[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{adjnode , d[adjnode]});
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(d[i] > disappear[i])
                d[i] = -1;
        }
        return d;
    }
}