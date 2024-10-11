class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFS(adj , visited , x);
        }
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        /*int cnr = 0;
        int cnl = 0;
        for(int i = 0; i < leftChild.length; i++){
            if(leftChild[i] == -1)
            cnl++;
            if(rightChild[i] == -1)
            cnr++;
        }
        if(cnr == n || cnl == n && n > 2)
        return false;*/
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[n];
         for(int i = 0; i < leftChild.length; i++){
            if(leftChild[i] != -1){
            adj.get(i).add(leftChild[i]);
            indegree[leftChild[i]]++;
            }
            if(rightChild[i] != -1){
            adj.get(i).add(rightChild[i]);
            indegree[rightChild[i]]++;
            }
        }
        int ec = 0;
        int c0 = 0;
        int c1 = 0;
        for(int i = 0; i < n; i++){
            ec += adj.get(i).size();
            if(indegree[i] == 0)
            c0++;
            else if(indegree[i] == 1)
            c1++;
        }
        int s = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                s = i;
                break;
            }
        }
        boolean[] visited = new boolean[n];
        if(s != -1)
        DFS(adj , visited , s);
        int tc = 0;
        for(int i = 0; i < n; i++){
            if(visited[i])
            tc++;
        }
        if(c0 == 1 && c1 == n-1 && ec == n-1 && tc == n)
        return true;
        else
        return false;
    }
}