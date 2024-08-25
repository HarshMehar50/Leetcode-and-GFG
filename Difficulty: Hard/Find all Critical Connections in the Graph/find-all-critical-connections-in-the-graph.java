//{ Driver Code Starts
//Initial Template for Java

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
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void DFS(int node , int parent , int timer , int[] discover , int[] low , ArrayList<ArrayList<Integer>> ans , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        discover[node] = low[node] = timer++;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == parent) continue;
            if(visited[adj.get(node).get(i)] == false){
                DFS(adj.get(node).get(i) , node , timer , discover , low , ans , adj , visited);
                low[node] = Math.min(low[node] , low[adj.get(node).get(i)]);
                if(low[adj.get(node).get(i)] > discover[node]){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(Math.min(node , adj.get(node).get(i)));
                    l.add(Math.max(node , adj.get(node).get(i)));
                    ans.add(l);
                }
            }else{
                low[node] = Math.min(low[node] , discover[adj.get(node).get(i)]);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
        HashMap<Integer , List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < v; i++){
            adjMap.put(i , adj.get(i));
        }
        int[] discover = new int[v];
        int[] low = new int[v];
        boolean[] visited = new boolean[v];
        Arrays.fill(visited , false);
        Arrays.fill(low , -1);
        Arrays.fill(discover , -1);
        int parent = -1;
        int timer = 0;
        for(int i = 0; i < v; i++){
            if(visited[i] == false){
                DFS(i , parent , timer , discover , low , ans , adjMap , visited);
            }
        }
        int[][] a = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            a[i][0] = ans.get(i).get(0);
            a[i][1] = ans.get(i).get(1);
        }
        Arrays.sort(a,(x , y)->x[0] != y[0]?Integer.compare(x[0] , y[0]):Integer.compare(x[1] , y[1]));
        for(int i = 0; i < a.length; i++){
            ArrayList<Integer> t = new ArrayList<>();
            t.add(a[i][0]);
            t.add(a[i][1]);
            fans.add(t);
        }
        return fans;
    }
}