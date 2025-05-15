class Solution {
    boolean check(int node , HashMap<Integer , int[]> adj , int[] alternate){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        alternate[node] = 0;
        while(!q.isEmpty()){
            int cnode = q.poll();
            for(int i = 0; i < adj.get(cnode).length; i++){
                if(alternate[adj.get(cnode)[i]] == -1){
                    alternate[adj.get(cnode)[i]] = 1-alternate[cnode];
                    q.offer(adj.get(cnode)[i]);
                }else if(alternate[adj.get(cnode)[i]] == alternate[cnode]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer , int[]> adj = new HashMap<>();
        for(int i = 0; i < graph.length; i++){
            adj.put(i , graph[i]);
        }
        int[] alternate = new int[adj.size()];
        Arrays.fill(alternate , -1);
        for(int i = 0; i < alternate.length; i++){
            if(alternate[i] == -1){
                if(!check(i , adj , alternate))
                    return false;
            }
        }
        return true;
    }
}