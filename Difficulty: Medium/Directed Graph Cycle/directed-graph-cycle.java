//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree = new int[V];
        for(ArrayList<Integer> l : adj){
            for(int i = 0; i < l.size(); i++){
                indegree[l.get(i)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int c = 0;
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0)
            q.offer(i);
        }
        while(!q.isEmpty()){
            c++;
            int node = q.poll();
            for(Integer x : adj.get(node)){
                indegree[x]--;
                if(indegree[x] == 0)
                q.offer(x);
            } 
        }
        if(c == V)
        return false;
        else
        return true;
    }
}