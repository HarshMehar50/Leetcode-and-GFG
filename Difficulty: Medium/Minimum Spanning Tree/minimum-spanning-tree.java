//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mst = new boolean[V];
        Arrays.fill(parent , -1);
        Arrays.fill(key , Integer.MAX_VALUE);
        key[0] = 0;
        for(int i= 0; i < V; i++){
            int min = Integer.MAX_VALUE;
            int u = 0;
            for(int v = 0; v < V; v++){
                if(!mst[v] && key[v] < min){
                    u = v;
                    min = key[v];
                }
            }
            mst[u] = true;
            List<int[]> c = adj.get(u);
            for(int j = 0; j < c.size(); j++){
                int v = c.get(j)[0];
                int w = c.get(j)[1];
                if(!mst[v] && w < key[v]){
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }
        int s = 0;
        for(int i = 0; i < V; i++){
            s += key[i];
        }
        return s;
    }
}