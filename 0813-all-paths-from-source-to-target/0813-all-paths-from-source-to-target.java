class Solution {
    void DFS(HashMap<Integer , int[]> adj , List<List<Integer>> ans , List<Integer> inner , int s , int d){
        inner.add(s);
        if(s == d){
        List<Integer> c = new ArrayList<>(inner);
        ans.add(c);
        return;
        }
        int[] child = adj.get(s);
        for(int i = 0; i < child.length; i++){
            DFS(adj , ans , inner , child[i] , d);
            inner.remove(inner.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer , int[]> adj = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            adj.put(i , graph[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        DFS(adj , ans , inner , 0 , graph.length-1);
        return ans;
    }
}