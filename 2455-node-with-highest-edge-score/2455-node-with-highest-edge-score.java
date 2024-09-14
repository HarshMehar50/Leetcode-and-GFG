class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        HashMap<Integer , List<Integer>> indegree = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            adj.put(i , new ArrayList<>());
            indegree.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            if(!adj.containsKey(i)){
            adj.put(i , new ArrayList<>());
            }
            adj.get(i).add(edges[i]);
            if(!indegree.containsKey(edges[i])){
            indegree.put(edges[i] , new ArrayList<>());
            }
            indegree.get(edges[i]).add(i);
        }
        long[] ans = new long[edges.length];
        for(int i = 0; i < indegree.size(); i++){
            long s = 0;
            for(int j = 0; j < indegree.get(i).size(); j++){
                 s += indegree.get(i).get(j);
            }
            ans[i] = s;
        }
        int index = 0;
        for(int i = 0; i < ans.length; i++){
            if(ans[index] < ans[i]){
                index = i;
            }
        }
        return index;
    }
}