//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    void DFS(HashMap<Integer , List<Integer>> adj , int node , boolean[] visited){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            DFS(adj , x , visited);
        }
    }
    public int isEulerCircuit(int V, List<Integer>[] adjList) 
    {
        // code here
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < V; i++){
            adj.put(i , adjList[i]);
        }
        int o = 0;
        int e = 0;
        int[] degree = new int[V];
        for(int i = 0; i < V; i++){
            degree[i] = adjList[i].size();
            if(degree[i]%2 == 0)
            e++;
            else 
            o++;
        }
        boolean[] visited = new boolean[V];
        int startNode = -1;
        for(int i = 0; i < V; i++){
            if(degree[i] > 0){
            startNode = i;
            break;
          }
        }
        if(startNode == -1)
        return 2;
        DFS(adj , startNode , visited);
        for(int i = 0; i < V; i++){
            if(!visited[i] && degree[i] > 0)
            return 0;
        }
        if(o == 0)
        return 2;
        else if(o == 2)
        return 1;
        else
        return 0;
    }
}