class Solution {
    int DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , int[] subtree , int[] quiet){
        if(subtree[node] != -1)
        return subtree[node];
        subtree[node] = node;
        for(Integer x : adj.get(node)){
            if(x != parent){
                int c = DFS(adj , x , node , subtree , quiet);
                if(quiet[c] < quiet[subtree[node]]){
                    subtree[node] = c;
                }
            }
        }
        return subtree[node];
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < quiet.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < richer.length; i++){
            adj.get(richer[i][1]).add(richer[i][0]);
            //adj.get(richer[i][0]).add(richer[i][1]);
        }
        int[] subtree = new int[quiet.length];
        Arrays.fill(subtree , -1);
        for(int i = 0; i < quiet.length; i++){
            if(subtree[i] == -1)
            subtree[i] = DFS(adj , i , -1 , subtree , quiet);
        }
        return subtree;
    }
}