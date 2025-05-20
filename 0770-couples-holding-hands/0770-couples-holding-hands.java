class Solution {
    void DFS(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFS(adj , visited , x);
        }
    }
    public int minSwapsCouples(int[] row) {
        int[] ci = new int[row.length];
        for(int i = 0; i < row.length; i++){
            ci[row[i]] = i/2;
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < row.length/2; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < row.length; i++){
            if(row[i]%2 == 0){
                if(!adj.get(ci[row[i]]).contains(ci[row[i]+1]))
                adj.get(ci[row[i]]).add(ci[row[i]+1]);
            }else{
                if(!adj.get(ci[row[i]]).contains(ci[row[i]-1]))
                adj.get(ci[row[i]]).add(ci[row[i]-1]);
            }
        }
        int c = 0;
        boolean[] visited = new boolean[row.length/2];
        for(int i = 0; i < row.length/2; i++){
            if(!visited[i]){
                c++;
                DFS(adj , visited , i);
            }
        }
        System.out.println(c);
        return (row.length/2)-c;
    }
}