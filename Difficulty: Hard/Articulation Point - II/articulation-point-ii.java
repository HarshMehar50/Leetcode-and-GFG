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
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    void DFS(int node , int parent , int timer , int[] discover , int[] low , List<Integer> result , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        discover[node] = low[node] = timer++;
        int child = 0;
        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == parent) continue;
            if(!visited[adj.get(node).get(i)]){
                DFS(adj.get(node).get(i) , node , timer , discover , low , result , adj , visited);
                low[node] = Math.min(low[node] , low[adj.get(node).get(i)]);
                if(low[adj.get(node).get(i)] >= discover[node] && parent != -1 && result.indexOf(node) == -1){
                    result.add(node);
                }
                child++;
            }else{
                low[node] = Math.min(low[node] , discover[adj.get(node).get(i)]);
            }
        }
        if(parent == -1 && child > 1 && result.indexOf(node) == -1){
            result.add(node);
        }
    }
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        List<Integer> result = new ArrayList<>();
        int[] discover = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(discover , -1);
        Arrays.fill(low , -1);
        int timer = 0;
        int parent = -1;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                DFS(i , parent , timer , discover , low , result , adj , visited);
            }
        }
        Collections.sort(result);
        if(result.size() != 0){
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
        }else{
            return new int[]{-1};
        }
    }
}