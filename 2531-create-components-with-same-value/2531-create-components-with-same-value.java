class Solution {
    
    int DFS1(HashMap<Integer , List<Integer>> adj , int[] nums , int cs , int nc , int[] c , int node , int parent){
        int s = nums[node];
        for(Integer x : adj.get(node)){
            if(x != parent)
            s += DFS1(adj , nums , cs , nc , c , x , node);
        }
        if(s == cs){
            c[0]++;
            return 0;
        }
        return s;
    }
    boolean check(HashMap<Integer , List<Integer>> adj , int[] nums , int cs , int nc){
        int[] c = {0};
        int parts = DFS1(adj , nums , cs , nc , c , 0 , -1);
        if(c[0] == nc)
        return true;
        else
        return false;
    }
    public int componentValue(int[] nums, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            adj.put(i , new ArrayList<>());
            s += nums[i];
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for(int i = s; i >= 1; i--){
            if(s%i == 0)
            if(check(adj , nums , s/i , i))
            return i-1;
        }
        return -1;
    }
}