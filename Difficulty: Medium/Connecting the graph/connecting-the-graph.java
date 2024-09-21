//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    void DFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> adj , int[] ans){
        visited[node] = true;
        ans[0]++;
        ans[1] += adj.get(node).size();
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFS(x , visited , adj , ans);
        }
    }
    /*int[] countEdges(HashMap<Integer , List<Integer>> adj , int start){
        int c = 0;
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        visited[start] = true;
        while(!s.isEmpty()){
            int node = s.pop();
            c += adj.get(node).size();
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!visited[adj.get(node).get(i)]){
                    visited[adj.get(node).get(i)] = true;
                    s.push(adj.get(node).get(i));
                }
            }
        }
        int v = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i])
            v++;
        }
        return new int[]{c , v};
    }*/
    public int Solve(int n, int[][] edge) {
        // Code here
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++){
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        boolean[] visited = new boolean[n];
        int c = 0;
        List<Integer> compStart = new ArrayList<>();
        List<int[]> details = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                c++;
                int[] ans = new int[2];
                compStart.add(i);
                DFS(i , visited , adj , ans);
                ans[1] = ans[1]/2;
                details.add(ans);
            }
        }
        /*boolean[] cvisited = new boolean[n];
        List<Integer> nedges = new ArrayList<>();
        List<Integer> nvertices = new ArrayList<>();
        for(int i = 0; i < compStart.size(); i++){
            int[] a = countEdges(adj , compStart.get(i));
            int ne = a[0];
            int nv = a[1];
            nedges.add(ne/2);
            nvertices.add(nv);
        }
        int extra = 0;
        for(int i = 0; i < nedges.size(); i++){
            if(nedges.get(i) >= nvertices.get(i))
            extra += (nedges.get(i)-(nvertices.get(i)-1));
        }
        if(extra >= nedges.size()-1)
            return nedges.size()-1;
        else
        return -1;*/
        int extra = 0;
        for(int i = 0; i < details.size(); i++){
            if(details.get(i)[0] <= details.get(i)[1])
            extra += (details.get(i)[1]-(details.get(i)[0]-1));
        }
        if(extra >= c-1)
            return c-1;
        else
        return -1;
    }
}