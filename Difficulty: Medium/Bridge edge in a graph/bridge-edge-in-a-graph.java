//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    public static void DFS(int node , int parent , int timer , int[] discover , int[] low , ArrayList<ArrayList<Integer>> ans , HashMap<Integer , List<Integer>> adj , boolean[] visited){
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
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
        HashMap<Integer , List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < V; i++){
            adjMap.put(i , adj.get(i));
        }
        int[] discover = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(visited , false);
        Arrays.fill(low , -1);
        Arrays.fill(discover , -1);
        int parent = -1;
        int timer = 0;
        for(int i = 0; i < V; i++){
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
        ArrayList<Integer> s = new ArrayList<>();
        s.add(Math.min(c , d));
        s.add(Math.max(c , d));
        if(fans.contains(s))
        return 1;
        else
        return 0;
    }
}