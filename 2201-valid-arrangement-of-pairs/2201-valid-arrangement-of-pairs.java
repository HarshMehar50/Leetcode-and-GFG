class Solution {
    void DFS(int node , HashMap<Integer , List<Integer>> adj , List<Integer> path){
        while(adj.containsKey(node) && !adj.get(node).isEmpty()){
            int next = adj.get(node).remove(adj.get(node).size()-1);
            DFS(next , adj , path);
        }
        path.add(node);
    }
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < pairs.length; i++){
            adj.putIfAbsent(pairs[i][0] , new ArrayList<>());
            adj.putIfAbsent(pairs[i][1] , new ArrayList<>());
        }
        Set<Integer> set = adj.keySet();
        Map<Integer , Integer> indegree = new HashMap<>();
        Map<Integer , Integer> outdegree = new HashMap<>();
        for(int x : set){
            indegree.put(x , 0);
            outdegree.put(x , 0);
        }
        for(int i = 0; i < pairs.length; i++){
            adj.get(pairs[i][0]).add(pairs[i][1]);
            indegree.put(pairs[i][1] , indegree.getOrDefault(pairs[i][1] , 0)+1);
            outdegree.put(pairs[i][0] , outdegree.getOrDefault(pairs[i][0] , 0)+1);
        }
        int start = pairs[0][0];
        for(int x : set){
            if(outdegree.getOrDefault(x , 0)-indegree.getOrDefault(x , 0) == 1){
                start = x;
                break;
            }
        }
        List<Integer> path = new ArrayList<>();
        DFS(start , adj , path);
        Collections.reverse(path);
        int[][] ans = new int[path.size()-1][2];
        for(int i = 0; i < path.size()-1; i++){
            ans[i] = new int[]{path.get(i) , path.get(i+1)};
        }
        return ans;
    }
}