class Solution {
    void topSort(HashMap<Integer , List<Integer>> adj , boolean[] visited , Stack<Integer> s , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            topSort(adj , visited , s , x);
        }
        s.push(node);
    }
    void revDFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node , List<Integer> inner){
        visited[node] = true;
        inner.add(node);
        for(Integer x : adj.get(node)){
            if(!visited[x])
            revDFS(adj , visited , x , inner);
        }
    }
    public int[] countVisitedNodes(List<Integer> edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        HashMap<Integer , List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < edges.size(); i++){
            adj.put(i , new ArrayList<>());
            transpose.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i) != -1)
            adj.get(i).add(edges.get(i));
        }
        boolean[] visited = new boolean[edges.size()];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < edges.size(); i++){
            if(!visited[i])
            topSort(adj , visited , s , i);
        }
        for(int i = 0; i < edges.size(); i++){
            visited[i] = false;
            for(Integer x : adj.get(i)){
                transpose.get(x).add(i);
            }
        }
        int[] cycles = new int[edges.size()];
        while(!s.isEmpty()){
            int top = s.pop();
            if(!visited[top]){
                List<Integer> inner = new ArrayList<>();
                revDFS(transpose , visited , top , inner);
                if(inner.size() > 1){
                    for(Integer x : inner){
                        if(cycles[x] == 0)
                        cycles[x] += inner.size();
                        else
                        cycles[x] += inner.size()-1;
                    }
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[edges.size()];
        for(int i = 0; i < edges.size(); i++){
            if(cycles[i] > 0){
                ans[i] = cycles[i];
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer x : transpose.get(node)){
                if(ans[x] == 0){
                ans[x] = ans[node]+1;
                q.offer(x);
                }
            }
        }
        return ans;
    }
}