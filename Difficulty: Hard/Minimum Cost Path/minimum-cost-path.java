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
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(x[0] , y[0]));
        int[][] d = new int[grid.length][grid[0].length];
        for(int i = 0; i < d.length; i++){
            Arrays.fill(d[i] , Integer.MAX_VALUE);
        }
        int[] dR = {1 , 0 , -1 , 0};
        int[] dC = {0 , 1 , 0 , -1};
        d[0][0] = grid[0][0];
        pq.offer(new int[]{grid[0][0] , 0 , 0});
        while(!pq.isEmpty()){
            int distance = pq.peek()[0];
            int r = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if(r == grid.length-1 && c == grid[0].length-1)
            return distance;
            for(int i = 0; i < 4; i++){
                int nr = r+dR[i];
                int nc = c+dC[i];
                if(nr < grid.length && nr >= 0 && nc < grid[0].length && nc >= 0){
                    if(distance+grid[nr][nc] < d[nr][nc]){
                        d[nr][nc] = distance+grid[nr][nc];
                        pq.offer(new int[]{d[nr][nc] , nr , nc});
                    }
                }
            }
        }
        return -1;
    }
}