class Solution {
    boolean DFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node , int d){
        visited[node] = true;
        if(node == d)
            return true;
        boolean ans = false;
        for(Integer x : adj.get(node)){
            if(!visited[x])
                ans = ans||DFS(adj , visited , x , d);
        }
        return ans;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            boolean[] visited = new boolean[numCourses];
            boolean a = DFS(adj , visited , queries[i][0] , queries[i][1]);
            ans.add(a);
        }
        return ans;
    }
}