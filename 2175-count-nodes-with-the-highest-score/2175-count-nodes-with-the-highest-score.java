class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , int[] subtree){
        subtree[node] = 1;
        for(Integer x : adj.get(node)){
            if(x != parent){
                DFS(adj , x , node , subtree);
                subtree[node] += subtree[x];
            }
        }
    }
    public int countHighestScoreNodes(int[] parents) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < parents.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < parents.length; i++){
            if(parents[i] != -1){
                adj.get(parents[i]).add(i);
                adj.get(i).add(parents[i]);
            }
        }
        int[] subtree = new int[parents.length];
        DFS(adj , 0 , -1 , subtree);
        long[] score = new long[parents.length];
        Arrays.fill(score , 1);
        long max = 0;
        for(int i = 0; i < parents.length; i++){
            long p = 1;
            if(parents[i] != -1)
            p = parents.length-subtree[i];
            score[i] = score[i]*p;
            for(Integer x : adj.get(i)){
                if(x != parents[i])
                score[i] = score[i]*(long)subtree[x];
            }
            max = Math.max(max , score[i]);
        }
        int ans = 0;
        for(int i = 0; i < parents.length; i++){
            if(score[i] == max)
            ans++;
        }
        return ans;
    }
}