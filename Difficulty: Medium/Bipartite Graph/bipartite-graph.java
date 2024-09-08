//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    boolean check(ArrayList<ArrayList<Integer>>adj , int node , int[] alternate){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        alternate[node] = 0;
        while(!q.isEmpty()){
            int cnode = q.poll();
            for(int x : adj.get(cnode)){
                if(alternate[x] == -1){
                    alternate[x] = 1-alternate[cnode];
                    q.offer(x);
                }else if(alternate[x] == alternate[cnode]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] alternate = new int[V];
        Arrays.fill(alternate , -1);
        for(int i = 0; i < V; i++){
            if(alternate[i] == -1){
                if(!check(adj , i , alternate))
                return false;
            }
        }
        return true;
    }
}