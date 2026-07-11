class Solution {
    void DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited , List<Integer> list){
        list.add(node);
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(x , adj , visited , list);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int c = 0;
        List<Integer> start = new ArrayList<>();
        List<List<Integer>> comp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                c++;
                start.add(i);
                List<Integer> list = new ArrayList<>();
                DFS(i , adj , visited , list);
                comp.add(list);
            }
        }
        int connect = 0;
        for(List<Integer> l : comp){
            int s = 0;
            for(int i = 0; i < l.size(); i++){
                s += adj.get(l.get(i)).size();
            }
            s = s/2;
            if(s == l.size()*(l.size()-1)/2)
                connect++;
        }
        return connect;
    }
}