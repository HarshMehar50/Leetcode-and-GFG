//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    void topSort(int node , boolean[] visited , Stack<Integer> s , ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x])
            topSort(x , visited , s , adj);
        }
        s.push(node);
    }
    void revDFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> transpose){
        visited[node] = true;
        for(Integer x : transpose.get(node)){
            if(!visited[x])
            revDFS(x , visited , transpose);
        }
    } 
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i])
            topSort(i , visited , s , adj);
        }
        HashMap<Integer , List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < V; i++){
            transpose.put(i , new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            visited[i] = false;
            for(Integer x : adj.get(i)){
                transpose.get(x).add(i);
            }
        }
        int c = 0;
        while(!s.isEmpty()){
            int top = s.pop();
            if(!visited[top]){
                c++;
                revDFS(top , visited , transpose);
            }
        }
        return c;
    }
}
