//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph. 
    void DFS(int node , ArrayList<ArrayList<Integer>> adj , int[] disc , int[] low , boolean[] visited , boolean[] inStack , Stack<Integer> s , int[] timer , ArrayList<ArrayList<Integer>> ans){
        visited[node] = true;
        disc[node] = low[node] = timer[0]++;
        s.push(node);
        inStack[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                DFS(x , adj , disc , low , visited , inStack , s , timer , ans);
                low[node] = Math.min(low[node] , low[x]);
            }else{
                if(inStack[x])
                low[node] = Math.min(low[node] , disc[x]);
            }
        }
        if(disc[node] == low[node]){
            ArrayList<Integer> inner = new ArrayList<>();
            while(!s.isEmpty() && s.peek() != node){
                inner.add(s.peek());
                inStack[s.peek()] = false;
                s.pop();
            }
            inner.add(node);
            inStack[node] = false;
            s.pop();
            Collections.sort(inner);
            ans.add(inner);
        }
    }
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] timer = {0};
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i])
            DFS(i , adj , disc , low , visited , inStack , s , timer , ans);
        }
        Collections.sort(ans , (x , y)->Integer.compare(x.get(0) , y.get(0)));
        return ans;
    }
}