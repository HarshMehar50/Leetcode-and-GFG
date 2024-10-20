class Solution {
    int base = 0;
    int[] count;
    int N;
    void DFS(HashMap<Integer , List<Integer>> adj , int parent , int prev , int[] ans){
        for(Integer x : adj.get(parent)){
            if(x != prev){
                ans[x] = ans[parent]-count[x]+(N-count[x]);
                DFS(adj , x , parent , ans);
            }
        }
    }
    int DFSBase(HashMap<Integer , List<Integer>> adj , int current , int prev , int depth){
        int total = 1;
        base += depth;
        for(Integer x : adj.get(current)){
            if(x == prev) continue;
            total += DFSBase(adj , x , current , depth+1);
        }
        count[current] = total;
        return total;
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        count = new int[N];
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < N; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        base = 0;
        int s = DFSBase(adj , 0 , -1 , 0);
        int[] ans = new int[N];
        ans[0] = base;
        DFS(adj , 0 , -1 , ans);
        return ans;
    }
}