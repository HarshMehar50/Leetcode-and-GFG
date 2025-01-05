class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length == 0 || graph.length == 1)
        return 0;
        HashMap<Integer , int[]> adj = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            adj.put(i , graph[i]);
        }
        int allVisited = (1<<graph.length)-1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[graph.length][allVisited+1];
        for(int i = 0; i < graph.length; i++){
            q.offer(new int[]{i , (1<<i)});
            visited[i][(1<<i)] = true;
        }
        int ans = 0;
        while(!q.isEmpty()){
            int l = q.size();
            ans++;
            for(int j = 0; j < l; j++){
                int node = q.peek()[0];
                int mask = q.peek()[1];
                q.poll();
                for(int i = 0; i < adj.get(node).length; i++){
                    int nextMask = (mask|(1<<adj.get(node)[i]));
                    if(visited[adj.get(node)[i]][nextMask]) continue;
                    if(nextMask == allVisited)
                    return ans;
                    visited[adj.get(node)[i]][nextMask] = true;
                    q.offer(new int[]{adj.get(node)[i] , nextMask});
                }
            }
        }
        return -1;
    }
}