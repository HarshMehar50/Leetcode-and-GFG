class Solution {
    int c = 0;
    void DFS(HashMap<Integer , List<int[]>> adj , int node , int parent , boolean[] visited){
        visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(!visited[adj.get(node).get(i)[0]]){
                c += adj.get(node).get(i)[1];
                DFS(adj , adj.get(node).get(i)[0] , node , visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(new int[]{connections[i][1] , 1});
            adj.get(connections[i][1]).add(new int[]{connections[i][0] , 0});
        }
        boolean[] visited = new boolean[n];
        DFS(adj , 0 , -1 , visited);
        return c;
    }
}