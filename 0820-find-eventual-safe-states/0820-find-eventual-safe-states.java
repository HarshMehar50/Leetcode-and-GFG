class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int i = 0; i < adj.get(node).size(); i++){
                indegree[adj.get(node).get(i)]--;
                if(indegree[adj.get(node).get(i)] == 0)
                    q.offer(adj.get(node).get(i));
            }
        }
        Collections.sort(ans);
        return ans;
    }
}