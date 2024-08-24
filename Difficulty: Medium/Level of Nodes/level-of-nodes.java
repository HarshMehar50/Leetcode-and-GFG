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
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    List<List<Integer>> BFSLevel(ArrayList<ArrayList<Integer>> adj , int s){
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited , false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int l = q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < l; i++){
                int c = q.poll();
                inner.add(c);
                for(int j = 0; j < adj.get(c).size(); j++){
                    if(visited[adj.get(c).get(j)] == false) {
                        q.offer(adj.get(c).get(j));
                        visited[adj.get(c).get(j)] = true;
                    }
                }
            }
            list.add(inner);
        }
        return list;
    }

    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        List<List<Integer>> list = BFSLevel(adj , 0);
        int k = -1;
        for(int i= 0; i < list.size(); i++){
            if(list.get(i).contains(X)){
            k = i;
            break;
            }
        }
        return k;
    }
}