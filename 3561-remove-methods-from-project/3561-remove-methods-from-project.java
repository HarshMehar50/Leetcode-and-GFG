class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFS(adj , visited , x);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < invocations.length; i++){
            adj.get(invocations[i][0]).add(invocations[i][1]);
        }
        boolean[] infected = new boolean[n];
        DFS(adj , infected , k);
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i] && i != k && !infected[i])
            DFS(adj , visited , i);
        }
        boolean t = false;
        for(int i = 0; i < n; i++){
            if(visited[i] && infected[i]){
                t = true;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(t){
            for(int i = 0; i < n; i++){
                ans.add(i);
            }
        }else{
            for(int i = 0; i < n; i++){
                if(!infected[i])
                ans.add(i);
            }
        }
        return ans;
    }
}