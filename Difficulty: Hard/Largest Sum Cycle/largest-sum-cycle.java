// User function Template for Java

class Solution {
    void topSort(HashMap<Integer , List<Integer>> adj , boolean[] visited , Stack<Integer> s , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            topSort(adj , visited , s , x);
        }
        s.push(node);
    }
    void revDFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node , long[] a){
        visited[node] = true;
        a[0]++;
        a[1] += node;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            revDFS(adj , visited , x , a);
        }
    }
    public long largesSumCycle(int N, int Edge[]) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        HashMap<Integer , List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < N; i++){
            adj.put(i , new ArrayList<>());
            transpose.put(i , new ArrayList<>());
        }
        for(int i = 0; i < Edge.length; i++){
            if(Edge[i] != -1)
            adj.get(i).add(Edge[i]);
        }
        boolean[] visited = new boolean[N];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < N; i++){
            if(!visited[i])
            topSort(adj , visited , s , i);
        }
        for(int i = 0; i < N; i++){
            visited[i] = false;
            for(Integer x : adj.get(i)){
                transpose.get(x).add(i);
            }
        }
        long ans = -1;
        while(!s.isEmpty()){
            int top = s.pop();
            if(!visited[top]){
                long[] a = {0 , 0};
                revDFS(transpose , visited , top , a);
                if(a[0] > 1)
                ans = Math.max(ans , a[1]);
            }
        }
        return ans;
    }
}