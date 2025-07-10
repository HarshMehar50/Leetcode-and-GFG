class Solution {
    boolean valid(int node , HashMap<Integer , List<Integer>> adj , int[] color , int v , int uc){
        for(Integer x : adj.get(node)){
            if(color[x] == uc)
            return false;
        }
        return true;
    }
    boolean solve(HashMap<Integer , List<Integer>> adj , int v , int m , int node , int[] color){
        if(node == v)
        return true;
        for(int i = 1; i <= m; i++){
            if(valid(node , adj , color , v , i)){
                color[node] = i;
                if(solve(adj , v , m , node+1 , color))
                return true;
                color[node] = 0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < v; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] color = new int[v];
        return solve(adj , v , m , 0 , color);
    }
}