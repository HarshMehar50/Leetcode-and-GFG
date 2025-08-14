class Solution {
    /*int[] DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        int md = 0;
        int farthest = node;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                int[] result = DFS(x , adj , visited);
                int d = result[0]+1;
                if(d > md){
                    md = d;
                    farthest = result[1];
                }
            }
        }
        return new int[]{md , farthest};
    }
    int daimeter(HashMap<Integer , List<Integer>> adj , boolean[] visited , int node){
        int[] f = DFS(node , adj , visited);
        Arrays.fill(visited , false);
        int[] s = DFS(f[1] , adj , visited);
        return s[0];
    }*/
    int ans = 0;
    int DFS(HashMap<Integer , List<Integer>> adj , int node , int parent , String s){
        int longest = 0;
        int secondLongest = 0;
        for(Integer x : adj.get(node)){
            if(x != parent){
                int childLongest = DFS(adj , x , node , s);
                if(s.charAt(x) != s.charAt(node)){
                    if(childLongest > secondLongest)
                    secondLongest = childLongest;
                    if(secondLongest > longest){
                        int temp = longest;
                        longest = secondLongest;
                        secondLongest = temp; 
                    }
                }
            }
        }
        int up = Math.max(longest , secondLongest)+1;
        int down = longest+secondLongest+1;
        int onlyRoot = 1;
        ans = Math.max(ans , Math.max(onlyRoot , Math.max(up , down)));
        return Math.max(onlyRoot , up);
    }
    public int longestPath(int[] parent, String s) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            adj.put(i , new ArrayList<>());
        }
        /*for(int i = 0; i < s.length(); i++){
            if(parent[i] != -1 && s.charAt(i) != s.charAt(parent[i])){
                adj.get(i).add(parent[i]);
                adj.get(parent[i]).add(i);
            }
        }
        boolean[] visited = new boolean[s.length()]; 
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(!visited[i])
            ans = Math.max(ans , daimeter(adj , visited , i)+1);
        }
        return ans;*/
        for(int i = 0; i < s.length(); i++){
            if(parent[i] != -1){
                adj.get(i).add(parent[i]);
                adj.get(parent[i]).add(i);
            }
        }
        int temp = DFS(adj , 0 , -1 , s);
        return ans;
    }
}