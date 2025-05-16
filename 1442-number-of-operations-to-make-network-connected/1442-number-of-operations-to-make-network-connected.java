class Solution {
    void DFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> adj , int[] ans){
        visited[node] = true;
        ans[0]++;
        ans[1] += adj.get(node).size();
        for(Integer x : adj.get(node)){
            if(!visited[x])
                DFS(x , visited , adj , ans);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int c = 0;
        List<int[]> details = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                c++;
                int[] ans = new int[2];
                DFS(i , visited , adj , ans);
                ans[1] = ans[1]/2;
                details.add(ans);
            }
        }
        int extra = 0;
        for(int i = 0; i < details.size(); i++){
            if(details.get(i)[0] <= details.get(i)[1])
                extra += details.get(i)[1]-(details.get(i)[0]-1);
        }
        if(extra >= c-1)
            return c-1;
        else
            return -1;
    }
}