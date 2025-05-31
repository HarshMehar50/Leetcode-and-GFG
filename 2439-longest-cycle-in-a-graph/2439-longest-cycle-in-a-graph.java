class Solution {
    void topSort(int node , boolean[] visited , Stack<Integer> s , HashMap<Integer , List<Integer>> adj){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
                topSort(x , visited , s , adj);
        }
        s.push(node);
    }
    void revDFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> transpose , int[] a){
        visited[node] = true;
        a[0]++;
        a[1] += transpose.get(node).size();
        for(Integer x : transpose.get(node)) {
            if(!visited[x])
                revDFS(x , visited , transpose , a);
        }
    }
    public int longestCycle(int[] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            if(edges[i] == -1) continue;
            adj.get(i).add(edges[i]);
        }
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[edges.length];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i])
                topSort(i , visited , s , adj);
        }
        HashMap<Integer , List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            transpose.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            visited[i] = false;
            for(Integer x : adj.get(i)){
                transpose.get(x).add(i);
            }
        }
        int max = 0;
        while(!s.isEmpty()){
            int top = s.pop();
            if(!visited[top]){
                int[] a = new int[2];
                revDFS(top , visited , transpose , a);
                max = Math.max(max , a[0]);
            }
        }
        if(max != 1)
            return max;
        else
            return -1;
    }
}