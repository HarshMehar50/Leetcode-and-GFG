class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int node , boolean[] visited){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
                DFS(adj , x , visited);
        }
    }
    boolean check(int[][] edges , int skip){
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= edges.length; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[edges.length+1];
        boolean[] visited = new boolean[edges.length+1];
        for(int i = 0; i < edges.length; i++){
            if(i != skip){
                adj.get(edges[i][0]).add(edges[i][1]);
                indegree[edges[i][1]]++;
            }
        }
        indegree[0] = Integer.MAX_VALUE;
        int c0 = 0;
        int c1 = 0;
        int c = 0;
        for(int i = 1; i <= edges.length; i++){
            if(indegree[i] == 0)
                c0++;
            else if(indegree[i] == 1)
                c1++;
        }
        int start = -1;
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                start = i;
                break;
            }
        }
        if(start != -1)
            DFS(adj , start , visited);
        else if(start == -1)
            return false;
        for(int i = 1; i < visited.length; i++){
            if(visited[i])
                c++;
        }
        if(c0 == 1 && c1 == edges.length-1 && c == edges.length)
            return true;
        else
            return false;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] ans = new int[2];
        for(int i = 0; i < edges.length; i++){
            if(check(edges , i)){
                ans = edges[i];
            }
        }
        return ans;
    }
}