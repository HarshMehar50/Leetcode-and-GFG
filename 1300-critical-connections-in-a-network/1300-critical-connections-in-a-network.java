class Solution {
    public void DFS(int node , int parent , int timer , int[] discover , int[] low , List<List<Integer>> ans , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        discover[node] = low[node] = timer++;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == parent) continue;
            if(visited[adj.get(node).get(i)] == false){
                DFS(adj.get(node).get(i) , node , timer , discover , low , ans , adj , visited);
                low[node] = Math.min(low[node] , low[adj.get(node).get(i)]);
                if(low[adj.get(node).get(i)] > discover[node]){
                    List<Integer> l = new ArrayList<>();
                    l.add(node);
                    l.add(adj.get(node).get(i));
                    ans.add(l);
                }
            }else{
                low[node] = Math.min(low[node] , discover[adj.get(node).get(i)]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < connections.size(); i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        int[] discover = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited , false);
        Arrays.fill(low , -1);
        Arrays.fill(discover , -1);
        int parent = -1;
        int timer = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                DFS(i , parent , timer , discover , low , ans , adj , visited);
            }
        }
        return ans;
    }
}