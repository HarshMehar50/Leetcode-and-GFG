class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , int[][] subtree , String labels){
        subtree[node][(int)(labels.charAt(node)-'a')]++;
        for(Integer x : adj.get(node)){
            if(x != parent){
                DFS(adj , x , node , subtree , labels);
                for(int i = 0; i < 26; i++){
                    subtree[node][i] += subtree[x][i];
                }
            }
        }
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[][] subtree = new int[n][26];
        DFS(adj , 0 , -1 , subtree , labels);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = subtree[i][(int)(labels.charAt(i)-'a')];
        }
        return ans;
    }
}