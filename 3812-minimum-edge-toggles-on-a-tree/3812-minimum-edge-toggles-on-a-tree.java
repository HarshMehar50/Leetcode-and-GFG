class Solution {
    void DFS(HashMap<Integer , List<int[]>> adj , int node , int parent , int e , StringBuilder s , StringBuilder t , List<Integer> ans){
        for(int[] a : adj.get(node)){
            if(a[0] != parent)
            DFS(adj , a[0] ,  node , a[1] , s , t , ans);
        }
        if(s.charAt(node) != t.charAt(node) && e != -1){
            ans.add(e);
            s.setCharAt(node , (char)(((s.charAt(node)-'0'+1)%2)+'0'));
            s.setCharAt(parent , (char)(((s.charAt(parent)-'0'+1)%2)+'0'));
        }
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , i});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , i});
        }
        StringBuilder s = new StringBuilder(start);
        StringBuilder t = new StringBuilder(target);
        List<Integer> ans = new ArrayList<>();
        DFS(adj , 0 , -1 , -1 , s , t , ans);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                List<Integer> l = new ArrayList<>();
                l.add(-1);
                return l;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}