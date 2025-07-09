class TreeAncestor {
    HashMap<Integer , List<Integer>> adj;
    int[][] ancestors;
    void DFS(int node , int parent){
        ancestors[node][0] = parent;
        for(int i = 1; i < ancestors[0].length; i++){
            if(ancestors[node][i-1] != -1)
                ancestors[node][i] = ancestors[ancestors[node][i-1]][i-1];
        }
        for(Integer x : adj.get(node)){
            if(x != parent)
                DFS(x , node);
        }
    }
    public TreeAncestor(int n, int[] parent) {
        adj = new HashMap<>();
        ancestors = new int[n][(int)(Math.log(n)/Math.log(2))+1];
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
            Arrays.fill(ancestors[i] , -1);
        }
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == -1) continue;
            adj.get(i).add(parent[i]);
            adj.get(parent[i]).add(i);
        }
        DFS(0 , -1);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i = 0; i < ancestors[0].length; i++){
            if((k&(1<<i)) > 0){
                node = ancestors[node][i];
                if(node == -1)
                    break;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */