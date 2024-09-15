class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < edges.size(); i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            indegree[edges.get(i).get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0)
            result.add(i);
        }
        return result;
    }
}