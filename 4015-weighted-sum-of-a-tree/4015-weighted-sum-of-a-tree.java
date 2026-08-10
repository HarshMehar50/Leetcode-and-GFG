class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , int[] d){
        for(Integer x : adj.get(node)){
            if(x != parent){
                d[x] = d[node]+1;
                DFS(adj , x , node , d);
            }
        }
    }
    public long weightedSum(int[] parent, int[] nums) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < parent.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < parent.length; i++){
            if(parent[i] != -1){
                adj.get(i).add(parent[i]);
                adj.get(parent[i]).add(i);
            }
        }
        int[] d = new int[parent.length];
        DFS(adj , 0 , -1 , d);
        long ans = 0;
        int maxd = 0;
        for(int i = 0; i < d.length; i++){
            maxd = Math.max(maxd , d[i]);
        }
        for(int i = 0; i < d.length; i++){
            ans += (long)((long)nums[i]*(long)(maxd-d[i]+1));
        }
        return ans;
    }
}