class Solution {
    int[] DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        int md = 0;
        int farthest = node;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                int[] result = DFS(x , adj , visited);
                int d = result[0]+1;
                if(d > md){
                    md = d;
                    farthest = result[1];
                }
            }
        }
        return new int[]{md , farthest};
    }
    int daimeter(HashMap<Integer , List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        int[] f = DFS(0 , adj , visited);
        Arrays.fill(visited , false);
        int[] s = DFS(f[1] , adj , visited);
        return s[0];
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer , List<Integer>> adj1 = new HashMap<>();
        HashMap<Integer , List<Integer>> adj2 = new HashMap<>();
        for(int i = 0; i < edges1.length+1; i++){
            adj1.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges2.length+1; i++){
            adj2.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges1.length; i++){
            adj1.get(edges1[i][0]).add(edges1[i][1]);
            adj1.get(edges1[i][1]).add(edges1[i][0]);
        }
        for(int i = 0; i < edges2.length; i++){
            adj2.get(edges2[i][0]).add(edges2[i][1]);
            adj2.get(edges2[i][1]).add(edges2[i][0]);
        }
        int d1 = daimeter(adj1);
        int d2 = daimeter(adj2);
        int nd1 = d1+1;
        int nd2 = d2+1;
        return (nd1/2 + nd2/2 + 1);
    }
}