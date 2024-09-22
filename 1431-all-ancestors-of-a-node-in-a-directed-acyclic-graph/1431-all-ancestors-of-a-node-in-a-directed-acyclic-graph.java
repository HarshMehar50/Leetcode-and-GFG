class Solution {
    List<Integer> DFS(HashMap<Integer , List<Integer>> adj , int src){
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        s.push(src);
        visited[src] = true;
        List<Integer> list = new ArrayList<>();
        while(!s.isEmpty()){
            int node = s.pop();
            list.add(node);
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!visited[adj.get(node).get(i)]){
                    s.push(adj.get(node).get(i));
                    visited[adj.get(node).get(i)] = true;
                }
            }
        }
        list.remove(0);
        Collections.sort(list);
        return list;
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ans.add(DFS(adj , i));
        }
        return ans;
    }
}