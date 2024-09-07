class Solution {
    static void DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(x , adj , visited);
            }
        }
    }
    int connected(HashMap<Integer , List<Integer>> adj){
        int c = 0;
        boolean[] visited = new boolean[adj.size()+1];
        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
            c++;
            DFS(i , adj , visited);
            }
        }
        return c;
    }
    boolean isCyclic(HashMap<Integer , List<Integer>> adj , int s , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node]){
                return true;
            }
            visited[node] = true;
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!visited[adj.get(node).get(i)])
                q.offer(adj.get(node).get(i));
            }
        }
        return false;
    }
    boolean detectCycle(HashMap<Integer , List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()+1];
        for(int i = 1; i < visited.length; i++){
            if(!visited[i] && isCyclic(adj , i , visited)){
                return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= edges.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int ans[] = {-1 , -1};
        for(int i = 0; i < edges.length; i++){
            int r1 = adj.get(edges[i][0]).indexOf(edges[i][1]);
            int r0 = adj.get(edges[i][1]).indexOf(edges[i][0]);
            int e1 = adj.get(edges[i][0]).get(r1);
            int e0 = adj.get(edges[i][1]).get(r0);
            adj.get(edges[i][0]).remove(r1);
            adj.get(edges[i][1]).remove(r0);
            int c = connected(adj);
            if(c == 1 && !detectCycle(adj))
            ans = edges[i];
            adj.get(edges[i][0]).add(e1);
            adj.get(edges[i][1]).add(e0);
        }
        return ans;
    }
}