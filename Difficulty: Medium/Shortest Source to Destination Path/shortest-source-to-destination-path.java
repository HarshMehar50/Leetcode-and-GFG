//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0] == 0)
        return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 , 0 , 0 , A[0][0]});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        int[] dC = {0 , 1 , 0 , -1};
        int[] dR = {1 , 0 , -1 , 0};
        while(!q.isEmpty()){
            int count = q.peek()[0];
            int r = q.peek()[1];
            int c = q.peek()[2];
            int n = q.peek()[3];
            q.poll();
            if(r == X && c == Y)
            return count;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc] && A[nr][nc] == 1){
                    q.offer(new int[]{count+1 , nr , nc , A[nr][nc]});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
};