//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    void DFS(int node , int parent , int timer , int[] discovery , int[] low , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        discovery[node] = low[node] = timer++;
        int child = 0;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == parent) continue;
            if(!visited[adj.get(node).get(i)]){
                DFS(adj.get(node).get(i) , node , timer , discovery , low , ans , adj , visited);
                low[node] = Math.min(low[node] , low[adj.get(node).get(i)]);
                if(low[adj.get(node).get(i)] >= discovery[node] && parent != -1){
                    ans.add(node);
                }
                child++;
            }else{
                low[node] = Math.min(low[node] , discovery[adj.get(node).get(i)]);
            }
        }
        if(parent == -1 && child > 1){
            ans.add(node);
        }
    }
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj){
        if(adj.size() <= 2){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(-1);
            return l;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int[] discovery = new int[V];
        int[] low = new int[V];
        Arrays.fill(discovery , -1);
        Arrays.fill(low , -1);
        boolean[] visited = new boolean[V];
        Arrays.fill(visited , false);
        int timer = 0;
        int parent = -1;
        for(int i = 0; i < V; i++){
            if(!visited[i])
                DFS(i , parent , timer , discovery , low , ans , adj , visited);
        }
        Collections.sort(ans);
        ArrayList<Integer> fans = new ArrayList<>();
        fans.add(ans.get(0));
        if(ans.size() > 1){
        for(int i= 1; i < ans.size(); i++){
            if(fans.contains(ans.get(i))) continue;
            fans.add(ans.get(i));
        }
        }
        return fans;
    }
}
        