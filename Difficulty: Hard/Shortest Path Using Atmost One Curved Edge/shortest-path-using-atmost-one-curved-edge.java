//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int[] dijkstra(HashMap<Integer , List<int[]>> adj , int n , int s){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[] d = new int[n+1];
        Arrays.fill(d , Integer.MAX_VALUE);
        d[s] = 0;
        pq.offer(new int[]{0 , s});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int weight = adj.get(node).get(i)[0];
                int adjnode = adj.get(node).get(i)[1];
                if(weight+distance < d[adjnode]){
                    d[adjnode] = weight+distance;
                    pq.offer(new int[]{d[adjnode] , adjnode});
                }
            }
        }
        return d;
    }
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        // code here
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            adj.get(edges.get(i).get(0)).add(new int[]{edges.get(i).get(2) , edges.get(i).get(1)});
            adj.get(edges.get(i).get(1)).add(new int[]{edges.get(i).get(2) , edges.get(i).get(0)});
        }
        int[] ds = dijkstra(adj , n , a);
        int[] dd = dijkstra(adj , n , b);
        if(ds[b] == Integer.MAX_VALUE)
        return -1;
        int min = ds[b];
        for(int i = 0; i < m; i++){
            if(ds[edges.get(i).get(0)] != Integer.MAX_VALUE && dd[edges.get(i).get(1)] != Integer.MAX_VALUE)
            min = Math.min(ds[edges.get(i).get(0)]+edges.get(i).get(3)+dd[edges.get(i).get(1)] , min);
            if(dd[edges.get(i).get(0)] != Integer.MAX_VALUE && ds[edges.get(i).get(1)] != Integer.MAX_VALUE)
            min = Math.min(dd[edges.get(i).get(0)]+edges.get(i).get(3)+ds[edges.get(i).get(1)] , min);
        }
        return min;
    }
};