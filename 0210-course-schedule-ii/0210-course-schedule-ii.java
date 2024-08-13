class Solution {
   /* List<Integer> BFS(HashMap<Integer , List<Integer>> adj , int numCourses , int src){
        List<Integer> bfsList = new ArrayList<>();
        int[] visited = new int[adj.size()];
        Arrays.fill(visited , false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            int current = q.poll();
            bfsList.add(current);
            List<Integer> currentlev = adj.get(current);
            for(int j = 0; j < currentlev.size(); j++){
                if(!visited[currentlev.get(j)]) {
                    q.offer(currentlev.get(j));
                    visited[currentlev.get(j)] = true;
                }
            }
        }
        return bfsList;
    }*/
   boolean isCyclicDFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , boolean[] dfsvisited , int node){
    visited[node] = dfsvisited[node] = true;
    for(int i = 0; i < adj.get(node).size(); i++){
        boolean ans = false;
        if(visited[adj.get(node).get(i)] == false)
        ans = isCyclicDFS(adj , visited , dfsvisited , adj.get(node).get(i));
        if(ans){
            return true;
        }else if(dfsvisited[adj.get(node).get(i)] == true){
            return true;
        }
    }
    dfsvisited[node] = false;
    return false;
   }
   boolean detectCycle(HashMap<Integer , List<Integer>> adj){
    boolean[] visited = new boolean[adj.size()];
    boolean[] dfsvisited = new boolean[adj.size()];
    Arrays.fill(visited , false);
    Arrays.fill(dfsvisited , false);
    for(int i = 0; i < adj.size(); i++) {
        if(visited[i] == false) {
            boolean ans = isCyclicDFS(adj , visited , dfsvisited , i);
            if(ans) {
                return true;
            }
        }
    }
    return false;
   }
    void DFS(HashMap<Integer , List<Integer>> adj , Stack<Integer> s , boolean[] visited , int node){
        visited[node] = true;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(!visited[adj.get(node).get(i)]){
                DFS(adj , s , visited , adj.get(node).get(i));
            }
        }
        s.push(node);
    }
    List<Integer> topologicalSort(HashMap<Integer , List<Integer>> adj){
        List<Integer> topoList = new ArrayList<>();
        if(detectCycle(adj)){
            return topoList;
        }
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited , false);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                DFS(adj , s , visited , i);
            }
        }
        while(!s.isEmpty()){
            topoList.add(s.peek());
            s.pop();
        }
        return topoList;
    }
    void createGraph(HashMap<Integer , List<Integer>> adj , int[][] prerequisites){
        for(int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            int[] a = new int[numCourses];
            for(int i = numCourses-1; i >= 0; i--){
                a[i] = i;
            }
            return a;
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i , new ArrayList<>());
        }
        createGraph(adj , prerequisites);
        List<Integer> topoList = topologicalSort(adj);
        int[] topo = new int[topoList.size()];
        for(int i = 0; i < topoList.size(); i++){
            topo[i] = topoList.get(i);
        }
        return topo;
    }
}