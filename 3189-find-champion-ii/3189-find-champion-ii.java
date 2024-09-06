class Solution {
    public int findChampion(int n, int[][] edges) {
        if(edges.length == 1){
            if(n == 2)
            return edges[0][0];
            else return -1;
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            adj.put(i ,  new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        int count = 0;
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
            count++;
            }
        }
        if(count > 1 || count == 0){
            return ans;
        }else{
            for(int i = 0; i < n; i++){
            if(indegree[i] == 0)
            ans = i;
            }
            return ans;
        }
    }
}