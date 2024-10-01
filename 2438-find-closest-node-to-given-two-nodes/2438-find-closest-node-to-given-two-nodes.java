class Solution {
    /*List<Integer> BFS(HashMap<Integer , List<Integer>> , int s){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(s);
        visited[s] = true;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!visited[adj.get(node).get(i)]){
                    q.offer(adj.get(node).get(i));
                    visited[adj.get(node).get(i)] = true;
                }
            }
        }
        return list;
    }*/
    int[] dijkstra(HashMap<Integer , List<Integer>> adj , int s){
        Queue<int[]> pq = new LinkedList<>();
        int[] d = new int[adj.size()];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[s] = 0;
        pq.offer(new int[]{0 , s});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = 1;
                int adjnode = adj.get(node).get(i);
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i] != -1)
            adj.get(i).add(edges[i]);
        }
        int[] d1 = dijkstra(adj , node1);
        int[] d2 = dijkstra(adj , node2);
        int ans = Integer.MAX_VALUE;
        int ansi = -1;
        for(int i = 0; i < d1.length; i++){
            if(d1[i] == Integer.MAX_VALUE || d2[i] == Integer.MAX_VALUE) continue;
            if(Math.max(d1[i] , d2[i]) < ans){
                ans = Math.max(d1[i] , d2[i]);
                ansi = i;
            }
        }
        return ansi;
    }
}