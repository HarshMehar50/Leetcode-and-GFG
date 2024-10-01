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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int[] dR = {-2 , -2 , -1 , -1 , 1 , 1 , 2 , 2};
        int[] dC = {-1 , 1 , -2 , 2 , -2 , 2 , -1 , 1};
        Queue<int[]> q = new LinkedList<>();
        int[][] d = new int[N+1][N+1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        d[KnightPos[1]][KnightPos[0]] = 0;
        q.offer(new int[]{KnightPos[1] , KnightPos[0] , 0});
        while(!q.isEmpty()){
            int distance = q.peek()[2];
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            if(r == TargetPos[1] && c == TargetPos[0])
            return distance;
            for(int i = 0; i < 8; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr <= N && nr > 0 && nc <= N && nc > 0){
                    if(d[nr][nc] > distance+1){
                        d[nr][nc] = distance+1;
                        q.offer(new int[]{nr , nc , d[nr][nc]});
                    }
                }
            }
        }
        return -1;
    }
}