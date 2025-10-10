class Solution {
    int gcd(int a , int b){
        if(b == 0)
        return Math.abs(a);
        return gcd(b , a%b);
    }
    void DFS(HashMap<Integer , List<Integer>> adj , List<Integer>[] gcdList , List<Integer>[] l , int[] d , int[] nums , int node , int parent , int[] ans){
        int md = Integer.MIN_VALUE;
        int pnode = -1;
        for(Integer x : gcdList[nums[node]]){
            if(!l[x].isEmpty() && d[l[x].get(l[x].size()-1)] > md){
                md = d[l[x].get(l[x].size()-1)];
                pnode = l[x].get(l[x].size()-1);
            }
        }
        ans[node] = pnode;
        l[nums[node]].add(node);
        for(Integer x : adj.get(node)){
            if(x != parent){
                d[x] = d[node]+1;
                DFS(adj , gcdList , l , d , nums , x , node , ans);
            }
        }
        l[nums[node]].remove(l[nums[node]].size()-1);
    }
    public int[] getCoprimes(int[] nums, int[][] edges) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][1]);
        }
        List<Integer>[] l = new ArrayList[51];
        List<Integer>[] gcdList = new ArrayList[51];
        for(int i = 0; i <= 50; i++){
            l[i] = new ArrayList<>();
            gcdList[i] = new ArrayList<>();
        }
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                if(gcd(i , j) == 1)
                gcdList[i].add(j);
            }
        }
        int[] ans = new int[nums.length];
        int[] d = new int[nums.length];
        Arrays.fill(ans , -1);
        DFS(adj , gcdList , l , d , nums , 0 , -1 , ans);
        return ans;
    }
}