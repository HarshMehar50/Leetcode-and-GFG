class Solution {
    void DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(x , adj , visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= isConnected.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && i != j)
                    adj.get(i+1).add(j+1);
            }
        }
        boolean[] visited = new boolean[isConnected.length+1];
        Arrays.fill(visited , false);
        int c = 0;
        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                c++;
                DFS(i , adj , visited);
            }
        }
        return c;
    }
}