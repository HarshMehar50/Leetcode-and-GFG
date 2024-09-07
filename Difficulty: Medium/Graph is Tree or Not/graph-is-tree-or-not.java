//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    void DFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(x , adj , visited);
            }
        }
    }
    boolean isCyclic(HashMap<Integer , List<Integer>> adj , int s , boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node]){
                return true;
            }
            visited[node] = true;
            for(int j = 0; j < adj.get(node).size(); j++){
                if(!visited[adj.get(node).get(j)])
                q.offer(adj.get(node).get(j));
            }
        }
        return false;
    }
    boolean detectCycle(HashMap<Integer , List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        for(int i = 0; i < adj.size(); i++){
            if(!visited[i] && isCyclic(adj , i , visited)){
                return true;
            }
        }
        return false;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        if(m != n-1)
        return false;
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        int c = 0;
        boolean[] visited = new boolean[n];
        for(int i= 0; i < visited.length; i++){
            if(!visited[i]){
                c++;
                DFS(i , adj , visited);
            }
        }
        if(c == 1 && !detectCycle(adj))
        return true;
        else
        return false;
    }
}

