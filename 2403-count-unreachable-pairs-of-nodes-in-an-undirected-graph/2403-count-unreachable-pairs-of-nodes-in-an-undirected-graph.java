class Solution {
    void DFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> adj , int[] a){
        visited[node] = true;
        a[0]++;
        a[1] += adj.get(node).size();
        for(Integer x : adj.get(node)){
            if(!visited[x])
                DFS(x , visited , adj , a);
        }
    }
    public long countPairs(int n, int[][] edges) {
        if(edges.length == 0){
            return (long)((long)n*(long)(n-1)/2);
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int c = 0;
        boolean[] visited = new boolean[n];
        List<Integer> details = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                c++;
                int[] a = new int[2];
                DFS(i , visited , adj , a);
                details.add(a[0]);
            }
        }
        if(c == 1){
            return 0;
        }
        long ans = 0;
        for(int i = 0; i < details.size()-1; i++){
            long s = 0;
            for(int j = i+1; j < details.size(); j++){
                s += details.get(j);
            }
            ans += details.get(i)*s;
        }
        System.out.println(details);
        return ans;
    }
}