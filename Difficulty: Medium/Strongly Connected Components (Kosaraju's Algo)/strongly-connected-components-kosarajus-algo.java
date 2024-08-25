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
    public void revDFS(int node , boolean[] visited , HashMap<Integer , List<Integer>> transpose){
        visited[node] = true;
        for(Integer x : transpose.get(node)){
            if(visited[x] == false){
                revDFS(x , visited , transpose);
            }
        }
    }
    public void topSort(int node , boolean[] visited , Stack<Integer> s , HashMap<Integer , List<Integer>> adjMap){
        visited[node] = true;
        for(Integer x : adjMap.get(node)){
            if(visited[x] == false){
                topSort(x , visited , s , adjMap);
            }
        }
        s.push(node);
    }
    public int kosarajuAlgo(HashMap<Integer , List<Integer>> adjMap , int V){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited , false);
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                topSort(i , visited , s , adjMap);
            }
        }
        HashMap<Integer , List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < V; i++){
            transpose.put(i , new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            visited[i] = false;
            for(Integer x : adjMap.get(i)){
                transpose.get(x).add(i);
            }
        }
        int c = 0;
        while(!s.isEmpty()){
            int top = s.pop();
            if(visited[top] == false){
                c++;
                revDFS(top , visited , transpose);
            }
        }
        return c;
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        HashMap<Integer , List<Integer>> adjMap = new HashMap<>();
        for(int i = 0; i < adj.size(); i++){
            adjMap.put(i , adj.get(i));
        }
        int ans = kosarajuAlgo(adjMap , V);
        return ans;
    }
}
